const minSubArray = (inputArray, target) => {
  let array = new Uint8Array(inputArray);
  if (array.length === 1 || sumValues(array) < target) {
    return 0;
  }

  let minLength = array.length;
  let windowLength = 1;
  for (let i = 0; i < array.length - 1; i++) {
    let subArray = array.subarray(i, i + windowLength);
    let sum = sumValues(subArray);

    if (sum >= target) {

      if (minLength > subArray.length) {
        minLength = subArray.length;
      }
      windowLength--;
    } else {
      windowLength++;
      i--;
    }

    if (i + windowLength === array.length) {
      return minLength;
    }
  }

  return minLength;
};

const sumValues = (array) => {
  return array.reduce((left, right) => left + right, 0);
};

console.log(minSubArray([2, 3, 1, 2, 4, 3], 7) === 2);
console.log(minSubArray([2, 1, 6, 5, 4], 9) === 2);
console.log(minSubArray([3, 1, 7, 11, 2, 9, 8, 21, 72, 33, 19], 52) === 1);
console.log(minSubArray([1, 4, 16, 22, 5, 7, 8, 8, 10], 39) === 3);
console.log(minSubArray([1, 4, 16, 22, 5, 7, 8, 9, 10], 55) === 5);
console.log(minSubArray([4, 3, 3, 8, 1, 2, 3], 11) === 2);
console.log(minSubArray([1, 4, 16, 22, 5, 7, 8, 9, 10], 95) === 0);
