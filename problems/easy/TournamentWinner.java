import java.util.*;

class Program {

    public String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {

        // Team, points
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < competitions.size(); i++) {
            ArrayList<String> currentTeams = competitions.get(i);

            int winnerIdx = results.get(i) == 0 ? 1 : 0;
            int loserIdx = winnerIdx == 1 ? 0 : 1;

            String winner = currentTeams.get(winnerIdx);
            String loser = currentTeams.get(loserIdx);

            map.put(winner, map.getOrDefault(winner, 0) + 3);
            map.put(loser, map.getOrDefault(loser, 0));
        }

        Integer max = Integer.MIN_VALUE;
        String maxString = "";
        for (String key : map.keySet()) {

            if ( max < map.get(key)) {
                max = map.get(key);
                maxString = key;
            }
        }

        return maxString;
    }
}
