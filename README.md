# Neural Network Implementation in Java

This repository contains a Java implementation of a simple feedforward neural network with backpropagation.

## Files

### `Util.java`

This file contains utility functions for the neural network implementation.

- `loadCSV(String path)`: Loads a CSV file located at the given path and returns a List of String arrays.
- `normalizeByFeatureScaling(List<double[]> dataSet)`: Normalizes a dataset using feature scaling.
- `sigmoid(double x)`: Computes the sigmoid function for the given value.
- `derivativeSigmoid(double x)`: Computes the derivative of the sigmoid function for the given value.
- `max(double[] array)`: Returns the maximum value from the given array.

### `Neuron.java`

This file contains the Neuron class, representing a single neuron within the network.

- `Neuron(double learningRate, DoubleUnaryOperator activationFunction, DoubleUnaryOperator derivativeActivationFunction)`: Constructor for the Neuron class.
- `output(double[] inputs)`: Computes the output of this neuron for a given input array.
- `calculateDeltaForOutputLayer(double expectedValue)`: Calculates the delta value for this neuron in the output layer.
- `calculateDeltaForHiddenLayer(double[] nextLayerDeltas, double[] nextLayerWeights)`: Calculates the delta value for this neuron in a hidden layer.

### `Layer.java`

This file contains the Layer class, representing a layer of neurons within the network.

- `Layer(Optional<Layer> previousLayer, int numNeurons, double learningRate, DoubleUnaryOperator activationFunction, DoubleUnaryOperator derivativeActivationFunction)`: Constructor for the Layer class.
- `outputs(double[] input)`: Computes the outputs of all neurons in this layer for a given input array.
- `calculateDeltasForOutputLayer(double[] expected)`: Calculates the delta values for neurons in this output layer.
- `calculateDeltasForHiddenLayer(Layer nextLayer)`: Calculates the delta values for neurons in this hidden layer.

### `Network.java`

This file contains the Network class, representing the entire neural network structure.

- `Network(int[] layerStructure, double learningRate, DoubleUnaryOperator activationFunction, DoubleUnaryOperator derivativeActivationFunction)`: Constructor for the Network class.
- `outputs(double[] input)`: Computes the outputs of the entire network for a given input array.
- `backpropagate(double[] expected)`: Performs backpropagation for the entire network based on the expected output array.
- `updateWeights()`: Updates the weights of all neurons in the network based on the previously calculated delta values.
- `train(List<double[]> inputs, List<double[]> expecteds)`: Trains the network using a list of input arrays and a list of expected output arrays.
- `validate(List<double[]> inputs, List<T> expecteds, Function<double[], T> interpret)`: Validates the network's performance using a list of input arrays, a list of expected outputs, and a function to interpret the network's output.

### `IrisTest.java`

This file contains the IrisTest class, demonstrating the neural network's performance on the Iris dataset.

- `IrisTest()`: Constructor for the IrisTest class, loads and processes the Iris dataset.
- `irisInterpretOutput(double[] output)`: Interprets the network's output for the Iris dataset classification.
- `classify()`: Trains and tests the neural network on the Iris dataset, returning the classification results.

### `WineTest.java`

This file contains the WineTest class, demonstrating the neural network's performance on the Wine dataset.

- `WineTest()`: Constructor for the WineTest class, loads and processes the Wine dataset.
- `wineInterpretOutput(double[] output)`: Interprets the network's output for the Wine dataset classification.
- `classify()`: Trains and tests the neural network on the Wine dataset, returning the classification results.

## Usage

1. Compile and run the `IrisTest.java` file to test the neural network's performance on the Iris dataset:

```bash
javac IrisTest.java
java IrisTest
```

2. Compile and run the `WineTest.java` file to test the neural network's performance on the Wine dataset:

```bash
javac WineTest.java
java WineTest
```

## Iris Flower Dataset
The Iris Flower Dataset is a popular dataset used for machine learning and data analysis tasks. The dataset was introduced by the British statistician and biologist Ronald Fisher in his 1936 paper "The use of multiple measurements in taxonomic problems". The dataset consists of 150 samples from three species of Iris flowers (Iris setosa, Iris versicolor, and Iris virginica). Each sample has four features: sepal length, sepal width, petal length, and petal width, all measured in centimeters.

Dataset Structure
Each row of the dataset represents a sample with the following format:
```bash
<sepal_length>,<sepal_width>,<petal_length>,<petal_width>,<species>
```
Example
```bash
5.1,3.5,1.4,0.2,Iris-setosa
```
