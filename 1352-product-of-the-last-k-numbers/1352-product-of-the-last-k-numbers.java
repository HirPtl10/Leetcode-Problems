class ProductOfNumbers {
    ArrayList<Integer> arr;
    public ProductOfNumbers() {
        this.arr = new ArrayList<>();
    }
    
    public void add(int num) {
        arr.add(num);
    }
    
    public int getProduct(int k) {
        int prod = 1;
        for(int i = arr.size() - k; i < arr.size(); i++) {
            prod = prod * arr.get(i);
        }

        return prod;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */