# perceptron.py
# -------------
# Licensing Information:  You are free to use or extend these projects for
# educational purposes provided that (1) you do not distribute or publish
# solutions, (2) you retain this notice, and (3) you provide clear
# attribution to UC Berkeley, including a link to http://ai.berkeley.edu.
# 
# Attribution Information: The Pacman AI projects were developed at UC Berkeley.
# The core projects and autograders were primarily created by John DeNero
# (denero@cs.berkeley.edu) and Dan Klein (klein@cs.berkeley.edu).
# Student side autograding was added by Brad Miller, Nick Hay, and
# Pieter Abbeel (pabbeel@cs.berkeley.edu).


# Perceptron implementation
import util
PRINT = True

class PerceptronClassifier:
    """
    Perceptron classifier.

    An example is represented by a feature vector which is a util.Counter.
    """
    def __init__( self, legalLabels, max_iterations):
        self.legalLabels = legalLabels
        self.type = "perceptron"
        self.max_iterations = max_iterations
        self.weights = {}
        for label in legalLabels:
            # This is the data-structure you should use
            self.weights[label] = util.Counter()

    def setWeights(self, weights):
        assert len(weights) == len(self.legalLabels);
        self.weights = weights;

    def classify(self, data):
        """
        Classifies each example in data as the label that most closely
        matches the weight vector for that label.
        Return a list of classes for the data
        """
        guesses = []
        for f in data:
            scores = util.Counter()
            for each_label in self.legalLabels:
                scores[each_label] = self.weights[each_label] * f
            guess = scores.argMax() # This is Y
            guesses.append(guess)
        return guesses

    def train( self, trainingData, trainingLabels, validationData, validationLabels ):
        """
        The training loop for the perceptron passes through the training data
        several times and updates the weight vector for each label
        based on classification errors.

        Use the provided self.weights[label] data structure.

        Use self.legalLabels to iterate over all the labels.

        A training example is represented by a feature vector (f)
        which is a util.Counter.
        You can print a feature vector (f) to see what it looks like.
        Here's an example:
        {(7, 3): 0, (20, 25): 0, (16, 9): 1, (19, 4): 0, (17, 20): 1, ...}

        """
        # DO NOT ZERO OUT YOUR WEIGHTS BEFORE STARTING TRAINING, OR
        # THE AUTOGRADER WILL LIKELY DEDUCT POINTS.

        for iteration in range(self.max_iterations):
            print "Starting iteration ", iteration, "..."
            index = 0

            # f = feature vector = (Vector): Weight
            for f in trainingData:
                trainingLabel = trainingLabels[index] # Y*
                index += 1
                "*** YOUR CODE HERE.  Do NOT change anything above ***"

                " max_iterations yield 79/100 - Can we do better? "
                "   7 iterations yield 83/100 - Training works! "
                "  15 iterations yield 87/100 - Time complexity is awful! "

                # First, find our Y values
                scores = util.Counter()
                for each_label in self.legalLabels:
                    scores[each_label] = self.weights[each_label] * f

                # Take the best Y
                y = scores.argMax()

                # Next, compare the Y value with Y*
                # if Y==Y*, do nothing
                if y != trainingLabel:
                    # Lower the score of Y
                    self.weights[y] = self.weights[y] - f
                    # Raise the score of Y*
                    self.weights[trainingLabel] = self.weights[trainingLabel] + f
        # Repeat until no more significant changes
