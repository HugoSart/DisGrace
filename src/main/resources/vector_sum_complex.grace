var vet[10] = {0,1,2,3,4,5,6,7,8,9}: int;
var complex = 0, simple = 1: int;

def vector_sum(v1[], strategy: int): int {
    var i, sum: int;

    def complex(v1[]: int) {
        sum = 0;
        for (i = 0; i < 10; i +=1)
            sum += v1[i];
    }

    def simple(v1[]: int) {
        for (i = 0, sum = 0; i < 10; i += 1, sum += v1[i]) {
            write "";
        }
    }

    if (strategy == 0) complex(v1);
    else if (strategy == 1) simple(v1);
    else return -1;

    return sum;

}

def main() {
    var s: int;
    s = vector_sum(vet, complex);
    write "Sum: ", s;
}