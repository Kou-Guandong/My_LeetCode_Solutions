const twoSum = (nums, target) => {
    const map = {};
    for (let i = 0; i < nums.length; i++) {
        if (target - nums[i] in map) {
            return [map[target - nums[i]], i];
        }
        map[nums[i]] = i;
    }
}

console.log(twoSum([2, 1, 4, 8], 6)); // [0, 2]