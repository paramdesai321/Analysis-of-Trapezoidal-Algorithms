# Analysis-of-Trapezoidal-Algorithms

## Research Objective: 
Analyizing the complexity of Trapezium algorithm by Sequential and Parallel Computing. 

## Trapezoidal Rule 
The trapezoidal rule is a technique for numerical integration, i.e., approximating the definite integral: The trapezoidal rule works by approximating the region under the graph of the function as a trapezoid and calculating its area.
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

## Code

 1. Java Code for the Sequential and Parallel Implementation of the algorithm

 ``` src/ ``` Contains the Java code

 ``` NumericalIntegration.java ``` java code for the algorithm
 ```FPFunction.java``` java interface for the algorithm
 ```Main.java``` for testing purposes
 ```logs.txt``` testing dataset

 2. Python code for the plot

 ```Plot/``` Contains the Python code for the plot

 ```main.py``` main python file that uses different packages like csv, matlib, pyproject.toml and poetry.lock to create the plot of the computed dateset

 ```logs.txt``` testing dataset

## Testing on GPUs

-->We used NVIDIA's 2070 GPU to test 100,000,000 partitions on both the implementations. 
-->We tested upto 100,000,000 of input size on our GPU.

## Contributions

Advisor: Prof. Mohammed Abdelrahim of the California State University, Northridge;
Contributors: Roy Ananth, Sambahangphe Mishek, Shea Jackson, Ng Sunnathan and Desai Param. 




