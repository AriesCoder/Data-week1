// Starting array
let array = [28, 43, -12, 30, 4, 0, 0]
let result = true
// Write your solution below:

//change result to true in the first iteration
for(let i = 0; i < array.length -1 && result; i++){
    for(let j = i+1; j < array.length && result; j++){
        if(array[i] + array[j] === 0){
            result = false 
        }
    }
}
console.log(!result)
