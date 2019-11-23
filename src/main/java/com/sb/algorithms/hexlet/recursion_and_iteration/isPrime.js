const isPrime = (num) => {
    if ([-1, 0, 1].includes(num))
        return false;

    if (num < 0)
        return false;

    for (let i = 2; i < num; i++) {
        if (num % i === 0) return false;
    }

    return true;
};


console.log('7: ', isPrime(7) === true);

console.log('-3: ', isPrime(-3) === false);
console.log('-7: ', isPrime(-17) === false);
console.log('1: ', isPrime(1) === false);
console.log('10: ', isPrime(10) === false);

/*
Напишите функцию isPrime. Она принимает число и возвращает true, если число является простым, и false в ином случае.

Простое число — целое положительное число, имеющее ровно два различных натуральных делителя — единицу и самого себя.
Например, 7 — простое число, потому что делится без остатка только на 1 и на себя. 2017 — другое простое число.

Используйте цикл for и арифметические шорткаты.

isPrime(1);     // false
isPrime(7);     // true
isPrime(10);    // false
(Число 1 не считаем простым).
 */