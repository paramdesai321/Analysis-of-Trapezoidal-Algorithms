# Analysis-of-Trapezoidal-Algorithms

## Research Objective: 
Analyizing the complexity of Trapezium algorithm by Sequential and Parallel Computing. 

## Trapezoidal Rule 

Trapezoidal method is based on the principle that the area under the curve which is to be calculated is divided into number of small segments. The bounding curve in the segment is considered to be a straight line as a result the small enclosed area becomes a trapezium.

## Sequential Computing

Pseudo Code
```
function trapezium_integral(a, b, n, function_evaluator):
    # Calculate the width of each trapezoid
    range_width = (b - a) / n
    
    # Initialize sum to store the total area
    area_sum = 0.0
    
    # Iterate through each partition
    for i in range(1, n):
        # Calculate the x-coordinate within the partition
        x_coordinate = a + i * range_width
        
        # Evaluate the function at the current x-coordinate and add to sum
        area_sum = area_sum + function_evaluator(x_coordinate)
    
    # Add the average of the function values at the endpoints
    area_sum = area_sum + (function_evaluator(a) + function_evaluator(b)) / 2.0
    
    # Multiply by the width of each trapezoid and the reciprocal of the number of partitions
    result = area_sum * range_width / float(n)
    
    # Return the calculated result
    return result

```
This simplified pseudo code illustrates the trapezoidal rule for approximating integrals. It uses basic loops and arithmetic operations to calculate the area under the curve represented by the function function_evaluator. The result is an estimation of the definite integral within the specified range [a, b] using n partitions.

## Parallel Computing 

Pseudo Code:
```
function parallel_trapezium_integral(a, b, n, f):
    # Calculate the width of each trapezoid
    range_width = checkParamsGetRange(a, b, n)
    
    # Use parallel processing to calculate the sum of function values
    sum_of_function_values = parallel_sum(i -> f.eval(a + i * range_width / n), 0 to n-1)
    
    # Add the average of the function values at the endpoints
    sum_of_function_values = sum_of_function_values + (f.eval(a) + f.eval(b)) / 2.0
    
    # Multiply by the width of each trapezoid and the reciprocal of the number of partitions
    result = sum_of_function_values * range_width / float(n)
    
    # Return the calculated result
    return result
```
The parallel_sum function represents a parallelized sum operation over a range of values, which can be implemented using parallel processing constructs such as Java streams.

## Testing with GPUs

We wrote python code to analyze both 