class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        List<Triplet> list = new LinkedList<>(); 
        for(int[] triplet : triplets){
            list.add(new Triplet(triplet[0],triplet[1],triplet[2])); 
        }
        HashSet<Integer> result = new HashSet<>(); 
        list.stream()
            .filter(t -> {
                if(t.i <= target[0] && t.j <= target[1] && t.k <= target[2]) return true; 
                return false; 
            })
            .forEach(t -> {
                if(t.i == target[0]) result.add(0);
                if(t.j == target[1]) result.add(1);
                if(t.k == target[2]) result.add(2);
            });
        return result.size() == 3; 
    }
    public Triplet mergeTriplet(Triplet a, Triplet b){
        return new Triplet(Math.max(a.i,b.i),Math.max(a.j,b.j), Math.max(a.k,b.k));
    }
    record Triplet(int i, int j, int k){

    }
}