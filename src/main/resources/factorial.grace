def factorial(x: int): int {
    var i, j, r = 1: int;

    for (i = x; i > 0; i -= 1) {
        r *= i;
    }

    return r;

}

def main() {
    var num, fact: int;

    write "Insert the number: ";
    read num;
    fact = factorial(num);
    write "The factorial of ", num, " is ", fact, ".";

}