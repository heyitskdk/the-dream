# Check if String is Palindrome or Not

## Problem Description

A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward.

Alphanumeric characters include letters and numbers.

Given a string `s`, return `true` if it is a palindrome, or `false` otherwise.

## Problem Constraints

```text
1 <= s.length <= 2 * 10^5
s consists only of printable ASCII characters.
```

## Input Format

```text
The only argument given is a string s.
```

## Output Format

```text
Return true if s is a palindrome.
Return false otherwise.
```

## Example Input

### Input 1

```text
s = "A man, a plan, a canal: Panama"
```

### Input 2

```text
s = "race a car"
```

### Input 3

```text
s = " "
```

## Example Output

### Output 1

```text
true
```

### Output 2

```text
false
```

### Output 3

```text
true
```

## Example Explanation

### Explanation 1

```text
After converting uppercase letters into lowercase letters and removing non-alphanumeric characters,
the string becomes "amanaplanacanalpanama".

This is a palindrome.
```

### Explanation 2

```text
After converting uppercase letters into lowercase letters and removing non-alphanumeric characters,
the string becomes "raceacar".

This is not a palindrome.
```

### Explanation 3

```text
After removing non-alphanumeric characters, s becomes an empty string "".

Since an empty string reads the same forward and backward, it is a palindrome.
```