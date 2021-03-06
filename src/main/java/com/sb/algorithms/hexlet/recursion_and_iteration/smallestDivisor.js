// BEGIN (write your solution here)
const smallestDivisor = (num) => {
    if (num === 1) {
        return 1;
    } else if (num <= 0) {
        return NaN;
    } else {
        const iter = (candidate, num) => {
            if (num % candidate === 0) {
                return candidate;
            }
            return iter(candidate + 1, num);
        };

        return iter(2, num);
    }
// END
};

console.log(smallestDivisor(1) === 1);
console.log(smallestDivisor(2) === 2);
console.log(smallestDivisor(15) === 3);
console.log(smallestDivisor(17) === 17);
console.log(isNaN(smallestDivisor(0)));
console.log(isNaN(smallestDivisor(-3)));

/*
Реализуйте тело функции smallestDivisor, используя итеративный процесс. Эта функция должна находить наименьший делитель
 заданного числа.

Доп. условия: число, передаваемое в функцию, больше нуля; делитель должен быть больше единицы, за исключением случая,
когда аргументом является единица (наименьшим делителем которой является также единица).

Например, наименьший делитель числа 15 это 3.

smallestDivisor(15); // 3
smallestDivisor(17); // 17
Идея алгоритма:

Попробуйте разделить число на 2.
Если число делится без остатка, то это наименьший делитель.
Если нет, то попробуйте следующий делитель.
Если ничего не делит число без остатка, то переданное число является простым, так что его наименьший делитель — оно
само (не считая 1)
Подсказка
Вспомните про оператор % (modulus or остаток от деления) из урока 4. Он вычисляет остаток от деления одного операнда
на другой. Например, 11 % 5 это 1, а 10 % 2 это 0.

Так что если x % y это 0, то y делит x без остатка.
 */