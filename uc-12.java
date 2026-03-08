/**
 * ==========================================================
 * MAIN CLASS - UseCase12PalindromeCheckerApp
 * ==========================================================
 *
 * Use Case 12: Strategy Pattern for Palindrome Algorithms
 *
 * Description:
 * This class demonstrates how different palindrome
 * validation algorithms can be selected dynamically
 * at runtime using the Strategy design pattern.
 *
 * The application:
 * - Defines a common PalindromeStrategy interface
 * - Implements a concrete Stack-based strategy
 * - Injects the strategy at runtime
 * - Executes the selected algorithm
 *
 * @author Developer
 * @version 12.0
 */

public class UseCase12PalindromeCheckerApp {

    public static void main(String[] args) {

        String input = "racecar";

        PalindromeStrategy strategy = new StackStrategy();

        boolean result = strategy.isPalindrome(input);

        if (result) {
            System.out.println(input + " is a palindrome.");
        } else {
            System.out.println(input + " is NOT a palindrome.");
        }
    }
}


/**
 * ==========================================================
 * INTERFACE - PalindromeStrategy
 * ==========================================================
 *
 * This interface defines a contract for all
 * palindrome checking algorithms.
 */
interface PalindromeStrategy {

    boolean isPalindrome(String input);
}


/**
 * ==========================================================
 * CLASS - StackStrategy
 * ==========================================================
 *
 * Palindrome implementation using Stack.
 */
class StackStrategy implements PalindromeStrategy {

    public boolean isPalindrome(String input) {

        java.util.Stack<Character> stack = new java.util.Stack<>();

        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        String reversed = "";

        while (!stack.isEmpty()) {
            reversed += stack.pop();
        }

        return input.equalsIgnoreCase(reversed);
    }
}