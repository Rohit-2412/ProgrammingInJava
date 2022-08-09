package DSA.Searching_Sorting;

/*
Optimum location of point to minimize total distance

Given a set of points as and a line as ax+by+c = 0. We need to find a point on given line for which sum of distances 
from given set of points is minimum.

Approach ::
If we take one point on given line at infinite distance then total distance cost will be infinite, now when we move
this point on line towards given points the total distance cost starts decreasing and after some time, it again
starts increasing which reached to infinite on the other infinite end of line so distance cost curve looks like a
U-curve and we have to find the bottom value of this U-curve.

As U-curve is not monotonically increasing or decreasing we can’t use binary search for finding bottom most point,
here we will use ternary search for finding bottom most point, ternary search skips one third of search space at each
 iteration, you can read more about ternary search here.

So solution proceeds as follows, we start with low and high initialized as some smallest and largest values
respectively, then we start iteration, in each iteration we calculate two mids, mid1 and mid2, which represent 1/3rd
and 2/3rd position in search space, we calculate total distance of all points with mid1 and mid2 and update low or
high by comparing these distance cost, this iteration continues until low and high become approximately equal.

 */
public class OptimumLocation {
    
    static int EPS = (int) (1e-6 + 1);
    static int N = 5;
    
    public static void main(String[] args) {
        line l = new line(1, -1, -3);
        int[][] point = {{-3, -2},
                         {-1, 0},
                         {-1, 2},
                         {1, 2},
                         {3, 4},
                         };
        
        System.out.println(findOptimalDistance(point, l));
    }
    
    static double sq(double x) { return x * x; }
    
    static double dist(double x, double y, point p) {
        return Math.sqrt(sq(x - p.x) + sq(y - p.y));
    }
    
    static double computeDistance(point[] p, int n, line l, double X) {
        double res = 0;
        
        double Y = -1 * (l.c + l.a * X) / l.b;
        
        for (int i = 0; i < n; i++) {
            res += dist(X, Y, p[i]);
        }
        
        return res;
    }
    
    static double optimalDistanceCost(point[] p, int n, line l) {
        double low = -1e6;
        double high = 1e6;
        
        while ((high - low) > EPS) {
            
            // 0 - 1/3 = 1/3
            double mid1 = low + (high - low) / 3;
            
            // 1 - 1/3 = 2/3
            double mid2 = high - (high - low) / 3;
            
            double dist1 = computeDistance(p, n, l, mid1);
            double dist2 = computeDistance(p, n, l, mid2);
            
            if (dist1 < dist2) {
                high = mid2;
            }
            
            else {
                low = mid1;
            }
        }
        return computeDistance(p, n, l, (low + high) / 2);
    }
    
    static double findOptimalDistance(int[][] points, line l) {
        point[] p = new point[N];
        
        // converting 2d array to points
        for (int i = 0; i < N; i++) {
            p[i] = new point(points[i][0], points[i][1]);
        }
        return optimalDistanceCost(p, N, l);
    }
    
    static class point {
        int x, y;
        
        point() { }
        
        public point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    // class defining a line ax + by + c = 0 form
    static class line {
        int a, b, c;
        
        public line(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}
