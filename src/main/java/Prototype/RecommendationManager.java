package Prototype;

import java.util.ArrayList;
import java.util.List;

public class RecommendationManager {
    private List<Recommendation> recommendations;

    public RecommendationManager() {
        recommendations = new ArrayList<>();
    }

    public void addRecommendation(Recommendation recommendation) {
        recommendations.add(recommendation);
    }

    public Recommendation getRecommendation(int index) {
        if (index >= 0 && index < recommendations.size()) {
            return recommendations.get(index);
        }
        return null;
    }

    public List<Recommendation> getAllRecommendations() {
        return recommendations;
    }

    public void displayAllRecommendations() {
        if (recommendations.isEmpty()) {
            System.out.println("No recommendation lists available.");
            return;
        }

        for (int i = 0; i < recommendations.size(); i++) {
            System.out.println((i + 1) + ". " + recommendations.get(i));
        }
    }
}
