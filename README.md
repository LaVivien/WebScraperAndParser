# TwitterBot

## Description: 

Read tweets from CSV files into a program, build your own machine learning model, and create an AI that generates (sort of) realistic tweets! 

## Step1 : Data Cleaning

Filter and clean the raw tyouets with regular expression.

## Step2: Create MarkovChain

This is the core of the project. Pass in tweets as sequences of words, which will then be analyzed in pairs so that your model can figure out which words should follow which other words. 

One way to implement this would be to record a list of words that come after each word you find. you can do this by looking at individual pairs of adjacent words in your training text, which you'll call bigrams . Bigrams are going to be the basis of how your Markov Chain works. Say you have the following sentence, and you want to generate a list of bigrams:
"An apple is grown on an apple tree."

To make the list of bigrams, you'd start by taking the first pair of words: "An" and "apple," and putting them together in a bigram. After that, you'd move on to the next pair: "apple" and "is." Notice that the first and second pairs overlap. This is intentional! It allows us to represent the sentence as a linked chain of words, where you can move from one word to the next.

Here's the list of bigrams you get from continuing the process:
("An", "apple"), ("apple", "is"), ("is", "grown"), ("grown", "on"), ("on", an"), ("an", "apple"), ("apple", "tree"), ("tree", null)

Notice that you still create a bigram that starts with the last word, even though there's no word after it. This helps us keep track of which words take place at the end of a sentence, which you keep track of with an end marker. 

Now you can use this list of bigrams to generate what you call a probability distribution (also known as "frequency data") for each word. This probability distribution tells us how likely any word is to follow after a given word. you'll figure this out based on the number of times one word follows the previous one in your training data. To compute this distribution, you can start by listing out every unique word in the sentence and the list of words that you've seen after it in your set of bigrams.

Note that in your code for ProbabilityDistribution you represent the distribution as its corresponding frequency data, which maps strings to their frequencies. For instance, the probability distribution associated with "apple" maps "is" to 1 and "tree" to 1. This information is stored in the field called chain of the MarkovChain class.

The MarkovChain also has to keep track of which words might begin a sentence. To do so, you keep track of another probability distribution called startWords, which records the frequencies with which each word starts a sentence. In the simple example above, there was just one sentence and it began with "an", so the resulting distribution will just map "an" to 1. Richer training sets will include more starting words.

## Step 3: Generate sentences

Once the Markov Chain has been trained, you can use it to generate some entirely new sentences. you first select a start word based on the words that should showed up as start words in your training set. Since you only had one sentence, which started with "an," you have no choice but to select "an" as your start word. After that, you look at "an" in your probability distribution and randomly choose the word that goes next based on this distribution. It turns out that "apple" is the following word 100% of the time, so you'll choose apple. So far, your sentence is "An apple." Once you get to apple, your Markov Chain has a choice: it can choose "is" 50% of the time, or "tree" 50% of the time. Let's say it chooses tree. you then go to the probability distribution for "tree" and see that it can only ever be at the end of the sentence. As a result, your Markov Chain terminates with the (incomplete) sentence "An apple tree." As you can see, this process isn't very exciting with such a small training set, but you can get some really cool results once you start to play with real-world Twitter data! (Though even then, the model isn't sophisticated enough to truly take grammar into account.)

## Step 4: Generate TwitterBot

Use all of the classes you’ve written thus far to create a real working TwitterBot. The most important parts of this class are the constructor, which extracts sentences from the training tweets and uses them to train the Markov Chain, and the generateTweet() method, which uses the algorithm explained above in the Markov Chain section to generate the sentences that form the new tweet.


