
	Steps to run:

*Same as your provided code

1. Run the make file using "make -f makefile"
2. Start the program using "java ledger"
3. You will initially start in non-interactive mode. Please press i/I for entering interactive mode.
4. The commands entered in full words are ignored for case. For example Interactive, interactive, interActive all result in the toggling of interactive/non-interactive mode.
5. The input UTXOs sum amount and output UTXOs sum amount are supposed to be equal for the scope of my code. This is because of the assumption that the last output UTXO is the commission and hence both the amounts should be equal. Else, the transaction was deemed bad.


Report

Implementation:
Using the provided Ledger code as a backbone, I built on top of this. 

The default keys are provided for Alice, Bob, and Gopesh and are loaded automatically in the ledger class. 
This implementation uses the java PKCS8 KeyPair format. 
If you would like to try keys different then those I provided you can by adding files with the following names:
Alice.key
Alice.pub
Bob.key
Bob.pub
Gopesh.key
Gopesh.pup
As well you can generate new public keys separately and enter them in through the [r]ead key file option


Signature format:
0; ; 1; (Alice, 5000)

To generate a signature use this code in these methods:
in verifyGenesisSig
 RsaExample.sign(forSig, Person.getPersons().get(0).getKeyPair().getPrivate());
in verifySigAddBlock(String, String)
  RsaExample.sign(forSig, Person.getPerson(Tid).getKeyPair().getPrivate());

My implementation works primarily through the use of a Person object which generates and associates keys with both signatures and transactions.

I perform all my checks for validity before creating a transaction in the block and once valid I instantiate the Person object to keep track of all the attributes. 

Surely there are some edge case errors, however I believe all the necessary functionality is there.

Please don't hesitate to contact me should you have trouble.

