# multiAgents.py
# --------------
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


from util import manhattanDistance
from game import Directions
import random, util, sys

from game import Agent


def scoreEvaluationFunction(currentGameState):
    """
      This default evaluation function just returns the score of the state.
      The score is the same one displayed in the Pacman GUI.

      This evaluation function is meant for use with adversarial search agents
      (not reflex agents).
    """
    return currentGameState.getScore()


class MultiAgentSearchAgent(Agent):
    """
      This class provides some common elements to all of your
      multi-agent searchers.  Any methods defined here will be available
      to the MinimaxPacmanAgent, AlphaBetaPacmanAgent & ExpectimaxPacmanAgent.

      You *do not* need to make any changes here, but you can if you want to
      add functionality to all your adversarial search agents.  Please do not
      remove anything, however.

      Note: this is an abstract class: one that should not be instantiated.  It's
      only partially specified, and designed to be extended.  Agent (game.py)
      is another abstract class.
    """

    def __init__(self, evalFn = 'scoreEvaluationFunction', depth = '2'):
        self.index = 0 # Pacman is always agent index 0
        self.evaluationFunction = util.lookup(evalFn, globals())
        self.depth = int(depth)

class MinimaxAgent(MultiAgentSearchAgent):
    """
      Your minimax agent (question 1)
    """

    def getAction(self, gameState):
        """
          Returns the minimax action from the current gameState using self.depth
          and self.evaluationFunction.

          Here are some method calls that might be useful when implementing minimax.

          gameState.getLegalActions(agentIndex):
            Returns a list of legal actions for an agent
            agentIndex=0 means Pacman, ghosts are >= 1

          gameState.generateSuccessor(agentIndex, action):
            Returns the successor game state after an agent takes an action

          gameState.getNumAgents():
            Returns the total number of agents in the game
        """
        actions = dict()
        for a in gameState.getLegalActions(self.index):
            nextState = gameState.generateSuccessor(self.index, a)
            actions[a] = self.min_value(nextState, self.depth, self.index+1)           

        return max(actions, key=actions.get)


    def max_value(self, gameState, depth, agentIndex=0):
        """
        Calculates the max value.
        
        Args:
            gameState (object): The state of the current node
            depth (int): The current depth of the tree
            agentIndex (int): The current agent being evaluated - defaults to pacman (index 0)
        """
        actions =  gameState.getLegalActions(agentIndex)
        if not actions or depth == 0:
            return self.evaluationFunction(gameState)

        v = -sys.maxint
        for a in actions:
            nextState = gameState.generateSuccessor(agentIndex, a)
            v = max(v, self.min_value(nextState, depth, agentIndex+1))
        return v

    def min_value(self, gameState, depth, agentIndex):
        """
        Calculates the min value.
        
        Args:
            gameState (object): The state of the current node
            depth (int): The current depth of the tree
            agentIndex (int): The current agent being evaluated
        """
        actions = gameState.getLegalActions(agentIndex)
        if not actions or depth == 0:
            return self.evaluationFunction(gameState)

        v = sys.maxint
        if agentIndex == gameState.getNumAgents()-1:
            for a in actions:
                nextState = gameState.generateSuccessor(agentIndex, a)
                v = min(v, self.max_value(nextState, depth-1))
        else:
            for a in actions:
                nextState = gameState.generateSuccessor(agentIndex, a)
                v = min(v, self.min_value(nextState, depth, agentIndex+1))
        return v

class AlphaBetaAgent(MultiAgentSearchAgent):
    """
      Your minimax agent with alpha-beta pruning (question 2)
    """

    def getAction(self, gameState):
        """
          Returns the minimax action using self.depth and self.evaluationFunction
        """
        alpha = -sys.maxint
        actions = dict()
        for a in gameState.getLegalActions(self.index):
            nextState = gameState.generateSuccessor(self.index, a)
            actions[a] = self.min_value(nextState, alpha, sys.maxint, self.depth, self.index+1)
            alpha = max(alpha, actions[a])

        return max(actions, key=actions.get)

    def max_value(self, gameState, alpha, beta, depth, agentIndex=0):
        """
        Calculates the max value.
        
        Args:
            gameState (object): The state of the current node
            depth (int): The current depth of the tree
            agentIndex (int): The current agent being evaluated - defaults to pacman (index 0)
        """
        actions =  gameState.getLegalActions(agentIndex)
        if not actions or depth == 0:
            return self.evaluationFunction(gameState)

        v = -sys.maxint
        for a in actions:
            nextState = gameState.generateSuccessor(agentIndex, a)
            v = max(v, self.min_value(nextState, alpha, beta, depth, agentIndex+1))
            if v > beta:
                return v
            alpha = max(alpha, v)
        return v

    def min_value(self, gameState, alpha, beta, depth, agentIndex):
        """
        Calculates the min value.
        
        Args:
            gameState (object): The state of the current node
            depth (int): The current depth of the tree
            agentIndex (int): The current agent being evaluated
        """
        actions = gameState.getLegalActions(agentIndex)
        if not actions or depth == 0:
            return self.evaluationFunction(gameState)

        v = sys.maxint
        if agentIndex == gameState.getNumAgents()-1:
            for a in actions:
                nextState = gameState.generateSuccessor(agentIndex, a)
                v = min(v, self.max_value(nextState, alpha, beta, depth-1))
                if v < alpha:
                    return v
                beta = min(beta, v)
        else:
            for a in actions:
                nextState = gameState.generateSuccessor(agentIndex, a)
                v = min(v, self.min_value(nextState, alpha, beta, depth, agentIndex+1))
                if v < alpha:
                    return v
                beta = min(beta, v)
        return v
