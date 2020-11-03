const addDigits = (num) => {

    const iter = (input) => {
        if (input < 10)
            return input;

        let result = Array.from(input.toString())
            .reduce((left, right) => left + parseInt(right), 0);

        return iter(result);
    };

    return iter(num);
};

console.log(addDigits(0) === 0);
console.log(addDigits(5) === 5);
console.log(addDigits(10) === 1);
console.log(addDigits(19) === 1);
console.log(addDigits(38) === 2);
console.log(addDigits(1259) === 8);
console.log(addDigits(598997686567) === 4);
console.log(addDigits(999999999999) === 9);
