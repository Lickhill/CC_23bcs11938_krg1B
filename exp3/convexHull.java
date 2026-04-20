import java.util.*;

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class convexHull {

    static int orientation(Point p, Point q, Point r) {
        int val = (q.y - p.y) * (r.x - q.x) -
                (q.x - p.x) * (r.y - q.y);

        if (val == 0)
            return 0; // collinear
        return (val > 0) ? 1 : 2; // 1 -> clockwise, 2 -> counterclockwise
    }

    static int distSq(Point p1, Point p2) {
        return (p1.x - p2.x) * (p1.x - p2.x) +
                (p1.y - p2.y) * (p1.y - p2.y);
    }

    public static List<Point> convexHull(Point[] points) {

        int n = points.length;
        if (n < 3)
            return Arrays.asList(points);

        int ymin = points[0].y, min = 0;
        for (int i = 1; i < n; i++) {
            int y = points[i].y;

            if ((y < ymin) ||
                    (ymin == y && points[i].x < points[min].x)) {
                ymin = points[i].y;
                min = i;
            }
        }

        Point temp = points[0];
        points[0] = points[min];
        points[min] = temp;

        Point p0 = points[0];

        Arrays.sort(points, 1, n, (p1, p2) -> {
            int o = orientation(p0, p1, p2);
            if (o == 0)
                return distSq(p0, p1) - distSq(p0, p2);
            return (o == 2) ? -1 : 1;
        });

        Stack<Point> stack = new Stack<>();

        stack.push(points[0]);
        stack.push(points[1]);
        stack.push(points[2]);

        for (int i = 3; i < n; i++) {
            while (stack.size() > 1 &&
                    orientation(nextToTop(stack), stack.peek(), points[i]) != 2) {
                stack.pop();
            }
            stack.push(points[i]);
        }

        return new ArrayList<>(stack);
    }

    static Point nextToTop(Stack<Point> stack) {
        Point top = stack.pop();
        Point res = stack.peek();
        stack.push(top);
        return res;
    }

    public static void main(String[] args) {

        Point[] points = {
                new Point(0, 3),
                new Point(2, 2),
                new Point(1, 1),
                new Point(2, 1),
                new Point(3, 0),
                new Point(0, 0),
                new Point(3, 3)
        };

        List<Point> hull = convexHull(points);

        System.out.println("Convex Hull:");
        for (Point p : hull)
            System.out.println("(" + p.x + ", " + p.y + ")");
    }
}
