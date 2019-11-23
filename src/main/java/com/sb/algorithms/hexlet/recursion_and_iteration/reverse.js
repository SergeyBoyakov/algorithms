const reverse = (string) => {
    if (string.length <= 1) {
        return string;
    }

    let result = "";
    let index = string.length - 1;

    while (index >= 0) {
        result += string[index];
        index--;
    }

    return result;
};

console.log('empty: \t\t', reverse('') === '');
console.log('char:	\t', reverse('R') === 'R');
console.log('fo: \t\t', reverse('fo') === 'of')
console.log('one: \t\t', reverse('one') === 'eno');
console.log(' aaa dd s: \t', reverse(' aaa dd s') === 's dd aaa ');

