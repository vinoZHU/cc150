import java.util.*;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> _ids = new ArrayList<Integer>();
        ArrayList<Integer> _parents = new ArrayList<Integer>();
        ArrayList<Integer> _costs = new ArrayList<Integer>();

        _ids.add(1);
        _ids.add(2);
        _ids.add(3);
        _ids.add(4);

        _parents.add(0);
        _parents.add(0);
        _parents.add(1);
        _parents.add(1);

        _costs.add(2);
        _costs.add(3);
        _costs.add(2);
        _costs.add(3);

//        Scanner in = new Scanner(System.in);
//        String line = in.nextLine();
//
//        while(line != null && !line.isEmpty()) {
//            if(line.trim().equals("0")) break;
//            String []values = line.trim().split(" ");
//            if(values.length != 3) {
//                break;
//            }
//            _ids.add(Integer.parseInt(values[0]));
//            _parents.add(Integer.parseInt(values[1]));
//            _costs.add(Integer.parseInt(values[2]));
//            line = in.nextLine();
//        }
        int res = resolve(_ids, _parents, _costs);

        System.out.println(String.valueOf(res));
    }

    // write your code here
    public static int resolve(ArrayList<Integer> ids, ArrayList<Integer> parents, ArrayList<Integer> costs) {
        int length = ids.size();
        HashMap<Integer, Integer> costsMap = new HashMap<>();
        HashMap<Integer, Integer> parentMap = new HashMap<>();
        List<Integer> leafCost = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            costsMap.put(ids.get(i), costs.get(i));
            parentMap.put(ids.get(i), parents.get(i));
        }

        List<Integer> leafList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (!parents.contains(ids.get(i)))
                leafList.add(ids.get(i));
        }

        for (int i = 0; i < leafList.size(); i++) {
            int id = leafList.get(i);
            int cost = costsMap.get(id);
            while (true) {
                int parentId = parentMap.get(id);
                if (parentId == 0)
                    break;
                cost += costsMap.get(parentId);
                id = parentId;
            }
            leafCost.add(cost);

        }
        Collections.sort(leafCost);
        return leafCost.get(leafCost.size() - 1);
    }
}
