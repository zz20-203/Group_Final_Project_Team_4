/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Enterprise.AnalyticsDepartment;

import Business.Enterprise.DeliveryDepartment.Delivery;
import Business.Enterprise.DeliveryDepartment.DeliveryDirectory;
import Business.Enterprise.DeliveryDepartment.Rider;
import Business.OrderQueue.CoffeeOrderRequest;
import Business.OrderQueue.OrderQueue;
import Business.OrderQueue.OrderRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author Luciela us Biktria
 */
public abstract class AnalystHelper {
    
    /*
    * 1. Top 5 Fastest Riders
    * 2. Top 5 Slowest Riders
    * 3. Most and Least Active Riders (Number of Deliveries)
    * 4. Top 3 Destinations
    * 5. Most and Least Active Regions
    * 6. Most Popular Orders (all-inclusive, per-region, in-store, delivery only)
    * 7. Delivery Percentage
    */
    
    // Helper to Format Milliseconds to Minutes/Seconds ---
    private static String formatDuration(double ms) {
        long totalSeconds = (long) (ms / 1000);
        long minutes = totalSeconds / 60;
        long seconds = totalSeconds % 60;
        return String.format("%dm %ds", minutes, seconds);
    }
    
    // --- 1. & 2. Rider Delivery Times ---
    
    /**
     * Helper to calculate averages for all riders.
     */
    private static List<Map.Entry<Rider, Double>> getRiderAverageTimes(DeliveryDirectory directory) {
        Map<Rider, List<Long>> riderDurations = new HashMap<>();

        for (Delivery d : directory.getDeliveryList()) {
            // Only consider completed deliveries
            if (d.getDateTimeArrived() > 0 && d.getDateTimeSent() > 0) {
                long duration = d.getDateTimeArrived() - d.getDateTimeSent();
                // Sanity check for positive duration
                if (duration > 0) {
                    riderDurations.computeIfAbsent(d.getRider(), k -> new ArrayList<>()).add(duration);
                }
            }
        }

        Map<Rider, Double> averageMap = new HashMap<>();
        for (Map.Entry<Rider, List<Long>> entry : riderDurations.entrySet()) {
            double avg = entry.getValue().stream().mapToLong(val -> val).average().orElse(0.0);
            averageMap.put(entry.getKey(), avg);
        }

        List<Map.Entry<Rider, Double>> sortedList = new ArrayList<>(averageMap.entrySet());
        // Sort by Time Ascending (Shortest first)
        sortedList.sort(Map.Entry.comparingByValue());
        
        return sortedList;
    }

    public static String getTop5FastestRiders(DeliveryDirectory directory) {
        List<Map.Entry<Rider, Double>> sorted = getRiderAverageTimes(directory);
        
        if (sorted.isEmpty()) return "No delivery data available.";

        StringBuilder sb = new StringBuilder();
        sb.append("Top 5 Fastest Riders (Avg Duration):\n");
        
        int count = 0;
        for (Map.Entry<Rider, Double> entry : sorted) {
            if (count >= 5) break;
            sb.append(String.format("%d. %s %s - %s\n", 
                    (count + 1), 
                    entry.getKey().getFirstName(), 
                    entry.getKey().getLastName(), 
                    formatDuration(entry.getValue())));
            count++;
        }
        return sb.toString();
    }

    public static String getTop5SlowestRiders(DeliveryDirectory directory) {
        List<Map.Entry<Rider, Double>> sorted = getRiderAverageTimes(directory);
        
        if (sorted.isEmpty()) return "No delivery data available.";
        
        // Reverse for slowest
        Collections.reverse(sorted);

        StringBuilder sb = new StringBuilder();
        sb.append("Top 5 Slowest Riders (Avg Duration):\n");
        
        int count = 0;
        for (Map.Entry<Rider, Double> entry : sorted) {
            if (count >= 5) break;
            sb.append(String.format("%d. %s %s - %s\n", 
                    (count + 1), 
                    entry.getKey().getFirstName(), 
                    entry.getKey().getLastName(), 
                    formatDuration(entry.getValue())));
            count++;        }
        return sb.toString();
    }

    // --- 3. Most/Least Active Riders ---

    public static String getRiderActivityStats(DeliveryDirectory directory) {
        Map<Rider, Integer> counts = new HashMap<>();
        for (Delivery d : directory.getDeliveryList()) {
            counts.put(d.getRider(), counts.getOrDefault(d.getRider(), 0) + 1);
        }

        if (counts.isEmpty()) return "No deliveries found.";

        int max = Collections.max(counts.values());
        int min = Collections.min(counts.values());

        StringBuilder sb = new StringBuilder();
        
        sb.append("Most Active (").append(max).append(" deliveries):\n");
        counts.forEach((rider, count) -> {
            if (count == max) sb.append(" - ").append(rider.getFirstName()).append(" ").append(rider.getLastName()).append("\n");
        });

        sb.append("\nLeast Active (").append(min).append(" deliveries):\n");
        counts.forEach((rider, count) -> {
            if (count == min) sb.append(" - ").append(rider.getFirstName()).append(" ").append(rider.getLastName()).append("\n");
        });

        return sb.toString();
    }

    // --- 4. Top 3 Destinations ---

    public static String getTop3Destinations(DeliveryDirectory directory) {
        Map<String, Integer> counts = new HashMap<>();
        for (Delivery d : directory.getDeliveryList()) {
            String addr = d.getDestination().getAddress();
            counts.put(addr, counts.getOrDefault(addr, 0) + 1);
        }

        if (counts.isEmpty()) return "No destinations found.";

        // Check if any destination has > 1
        int globalMax = Collections.max(counts.values());
        if (globalMax <= 1) {
            return "No destination has received more than 1 delivery.";
        }

        List<Map.Entry<String, Integer>> sorted = new ArrayList<>(counts.entrySet());
        sorted.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        StringBuilder sb = new StringBuilder("Top 3 Destinations:\n");
        int count = 0;
        for (Map.Entry<String, Integer> entry : sorted) {
            if (count >= 3) break;
            sb.append(count + 1).append(". ").append(entry.getKey())
              .append(" (").append(entry.getValue()).append(")\n");
            count++;
        }
        return sb.toString();
    }

    // --- 5. Top 3 Regions (Most and Least Popular) ---

    public static String getRegionStats(DeliveryDirectory directory) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (Delivery d : directory.getDeliveryList()) {
            int region = d.getDestination().getRegion();
            counts.put(region, counts.getOrDefault(region, 0) + 1);
        }

        if (counts.isEmpty()) return "No region data available.";

        List<Map.Entry<Integer, Integer>> sorted = new ArrayList<>(counts.entrySet());
        sorted.sort(Map.Entry.comparingByValue()); // Ascending

        StringBuilder sb = new StringBuilder();
        
        // Least (Top of ascending list)
        sb.append("Regions with FEWEST deliveries:\n");
        for (int i = 0; i < Math.min(3, sorted.size()); i++) {
            sb.append("Region ").append(sorted.get(i).getKey())
              .append(": ").append(sorted.get(i).getValue()).append("\n");
        }

        // Most (Bottom of ascending list, iterate backwards)
        sb.append("\nRegions with MOST deliveries:\n");
        for (int i = sorted.size() - 1; i >= Math.max(0, sorted.size() - 3); i--) {
            sb.append("Region ").append(sorted.get(i).getKey())
              .append(": ").append(sorted.get(i).getValue()).append("\n");
        }

        return sb.toString();
    }

    // --- 6. Popular Orders ---

    public static String getPopularOrdersAnalysis(OrderQueue queue) {
        // Filter to Coffee requests only
        List<CoffeeOrderRequest> coffeeOrders = new ArrayList<>();
        for (OrderRequest r : queue.getWorkRequestList()) {
            if (r instanceof CoffeeOrderRequest) {
                coffeeOrders.add((CoffeeOrderRequest) r);
            }
        }

        if (coffeeOrders.isEmpty()) return "No orders found.";

        StringBuilder sb = new StringBuilder();

        // 1. Overall Most Popular
        sb.append("Most Popular Order (Overall): ").append(getMostPopularString(coffeeOrders)).append("\n\n");

        // 2. Most Popular excluding Region 0 (In-Store)
        List<CoffeeOrderRequest> deliveryOrders = coffeeOrders.stream()
                .filter(o -> o.getDestination() != null && o.getDestination().getRegion() != 0)
                .collect(Collectors.toList());
        sb.append("Most Popular Order (Delivery Only): ").append(getMostPopularString(deliveryOrders)).append("\n\n");

        // 3. Most Popular Per Region
        sb.append("Most Popular Per Region:\n");
        Map<Integer, List<CoffeeOrderRequest>> byRegion = coffeeOrders.stream()
                .filter(o -> o.getDestination() != null)
                .collect(Collectors.groupingBy(o -> o.getDestination().getRegion()));

        // Sort regions for display
        List<Integer> sortedRegions = new ArrayList<>(byRegion.keySet());
        Collections.sort(sortedRegions);

        for (Integer region : sortedRegions) {
            String regionName = (region == 0) ? "In-Store (0)" : "Region " + region;
            String popular = getMostPopularString(byRegion.get(region));
            sb.append(regionName).append(": ").append(popular).append("\n");
        }

        return sb.toString();
    }

    private static String getMostPopularString(List<CoffeeOrderRequest> orders) {
        if (orders == null || orders.isEmpty()) return "None";

        Map<String, Integer> counts = new HashMap<>();
        for (CoffeeOrderRequest o : orders) {
            String item = o.getMessage();
            if (item != null) {
                counts.put(item, counts.getOrDefault(item, 0) + 1);
            }
        }
        
        if (counts.isEmpty()) return "None";

        return Collections.max(counts.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    // --- 7. Delivery Percentage ---

    public static String getDeliveryPercentage(OrderQueue queue) {
        long totalCoffee = 0;
        long deliveryCount = 0;

        for (OrderRequest r : queue.getWorkRequestList()) {
            if (r instanceof CoffeeOrderRequest) {
                CoffeeOrderRequest c = (CoffeeOrderRequest) r;
                totalCoffee++;
                if (c.getDestination() != null && c.getDestination().getRegion() != 0) {
                    deliveryCount++;
                }
            }
        }

        if (totalCoffee == 0) return "0% (No orders)";

        double percent = ((double) deliveryCount / totalCoffee) * 100.0;
        return String.format("%.2f%% (%d out of %d orders were deliveries)", percent, deliveryCount, totalCoffee);
    }
}