import java.security.KeyPair;
import java.util.ArrayList;

public class Transaction {
  private String transactionID;
  private int inputSize;
  private int outputSize;
  private ArrayList<TxnIdIndexPair> inputTransactions;
  private ArrayList<UTXO> outputTransactions;
  private String transactionString;
  public Person myPerson;

  public String getTransactionString() {
    return transactionString;
  }

  public String getTransactionID() {
    return transactionID;
  }

  public int getInputSize() {
    return inputSize;
  }

  public int getOutputSize() {
    return outputSize;
  }

  public ArrayList<TxnIdIndexPair> getInputTransactions() {
    return inputTransactions;
  }

  public ArrayList<UTXO> getOutputTransactions() {
    return outputTransactions;
  }

  public Transaction(String transactionString, String txnId, int inputSize, int outputSize,
      ArrayList<TxnIdIndexPair> inputs, ArrayList<UTXO> outputs)  {
    this.transactionString = transactionString;
    this.transactionID = txnId;
    this.inputSize = inputSize;
    this.outputSize = outputSize;
    this.inputTransactions = inputs;
    this.outputTransactions = outputs;
    //First generate a public/private key pair
    KeyPair pair=null;
	try {
		pair = RsaExample.generateKeyPair();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	if (Person.getPersonName(outputs.get(0).getUser()) != null) {
		myPerson = Person.getPersonName(outputs.get(0).getUser());
	}
	else
		myPerson = new Person (outputs.get(0).getUser(),pair);
	
	myPerson.setTxnid(txnId);
	if (ledger.sig.length() > 10)
    myPerson.setSig(ledger.sig);
  
    myPerson.setTransationString(transactionString);
	
  }

}
