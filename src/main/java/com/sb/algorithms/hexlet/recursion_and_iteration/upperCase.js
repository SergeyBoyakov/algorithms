const solution = (str) => str.toString()
    .split(" ")
    .map((word) => word.charAt(0).toUpperCase() + word.substring(1))
    .join(" ");

console.log(solution('f') === 'F');
console.log(solution('f f') === 'F F');
console.log(solution('') === '');
console.log(solution('Aa aA') === 'Aa AA');
