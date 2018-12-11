var vet[3] = {1,2,3}: int;

def vector_sum(v[], size: int) {
    var i, sum = 0: int;

    for (i = 0; i < size; i += 1)
        sum += v[i];

    return sum;

}

def main() {
    var sum = vector_sum(vet, 3): int;
    write sum;
}