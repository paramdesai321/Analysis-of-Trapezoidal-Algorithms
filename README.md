# Analysis of Trapezoidal Algorithms

## Research Objective

Analyzing the complexity of Trapezium algorithm by Sequential and Parallel Computing.

### Trapezoidal Rule

The trapezoidal rule is a technique for numerical integration, approximating the definite integral by representing the region under the function graph as trapezoids and calculating their areas.

#### Sequential Computing - Pseudo Code

```python
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

#### Parallel Computing - Pseudo Code

```python
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

### Code

#### Java Implementation

- `src/` contains the Java code
  - `NumericalIntegration.java`: Java code for the algorithm
  - `FPFunction.java`: Java interface for the algorithm
  - `Main.java`: Testing purposes
  - `logs.txt`: Testing dataset

#### Python Plotting Code

- `Plot/` contains the Python code for the plot
  - `main.py`: Main Python file using packages like `csv`, `matlib`, `pyproject.toml`, and `poetry.lock` to create the plot of the computed dataset
  - `logs.txt`: Testing dataset

### Testing on GPUs

- We used NVIDIA's 2070 GPU to test 100,000,000 partitions on both implementations.
- Tested up to 100,000,000 of input size on our GPU.

## Time Complexity Analysis

The trapezium algorithm, tested with 100,000,000 partitions, exhibits **O(n)** time complexity in both sequential and parallel forms. The parallel version, leveraging sub-threads, demonstrates faster execution while maintaining the same **O(n)** time complexity.

## Contributions

- Advisor: Prof. Mohammed Abdelrahim of the California State University, Northridge
- Contributors: Roy Ananth, Sambahangphe Mishek, Shea Jackson, Ng Sunnathan, and Desai Param.