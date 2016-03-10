package casting;

/**
 * Compound assignment operator does implicit cast
 */
public class CompoundAssignmentOperator {
    public static void main(String[] args) {
        long _long = 10;
        int _int = 10;
        short _short = 10;

        _int = _int + _long;    // DOES NOT COMPILE
        _int += _long;          // COMPILE

        _short = _short + 1;    // DOES NOT COMPILE
        _short += _long;        // COMPILE
        _short += _int;         // COMPILE
        _short ++;
    }
}
