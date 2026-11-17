class Solution {
    public static boolean isPathCrossing(String path) {
        HashSet<Point> visited = new HashSet<>();
        Point p = new Point(0,0);
        visited.add(p);
        for(char c : path.toCharArray()){
            if(c == 'N'){
                p.y ++;
                if(visited.contains(p)) return true;
                visited.add(p);
            } else if(c == 'S'){
                p.y --;
                if(visited.contains(p)) return true;
                visited.add(p);
            } else if(c =='E'){
                p.x ++;
                if(visited.contains(p)) return true;
                visited.add(p);
            } else{
                p.x -- ;
                if(visited.contains(p)) return true;
                visited.add(p);
            }
        }
        return false;
    }
}


class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}