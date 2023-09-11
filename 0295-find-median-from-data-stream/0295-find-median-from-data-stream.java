class MedianFinder {
    PriorityQueue<Integer> minheap;
    PriorityQueue<Integer> maxheap;
    int size = 0;

    public MedianFinder() {
        minheap = new PriorityQueue<>();
        maxheap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        size++;
        int capacity = (size % 2 == 0) ? size / 2 : size / 2 + 1;
        // we have to maintain at least capacity elements in min heap and every element in min
        // heap should be greater than or equal to maximum ele of max heap
        if (minheap.size() < capacity) {
            if (!maxheap.isEmpty()&&maxheap.peek() > num) {
                minheap.offer(maxheap.poll());
                maxheap.offer(num);
            }else{
                minheap.offer(num);
            }
        } else {
            if (num > minheap.peek()) {
                maxheap.offer(minheap.poll());
                minheap.offer(num);
            } else {
                maxheap.offer(num);
            }
        }


    }

    public double findMedian() {
        if (size % 2 == 1) {
            return minheap.peek();
        }
        return (double) (minheap.peek() + maxheap.peek()) / 2;

    }
}
/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */