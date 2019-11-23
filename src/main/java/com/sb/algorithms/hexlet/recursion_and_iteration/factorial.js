const factorial = (n) => {

    const iter = (counter, accumulator) => {
        if (counter === 1)
            return accumulator;


        return iter(counter - 1, counter * accumulator);
    };

    return iter(n, 1);

};

console.log(factorial(1) === 1);
console.log(factorial(2) === 2);
console.log(factorial(4) === 24);
