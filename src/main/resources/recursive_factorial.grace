def factorial(x: int): int {
    if (x == 1) return 1;
    else {
        return x * factorial(x - 1);
    }
}

def main() {
    var num, fact: int;

    write "Insert the number: ";
    read num;
    fact = factorial(num);
    write "The factorial of ", num, " is ", fact, ".";
}