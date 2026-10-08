class Solution {
    public boolean isPowerOfFour(int n) {
        // n > 0: Must be positive
        // (n & (n - 1)) == 0: Must be a power of two
        // (n & 0x55555555) != 0: The single bit must be at an even bit position (0, 2, 4...)
        return n > 0 && (n & (n - 1)) == 0 && (n & 0x55555555) != 0;
    }
}
