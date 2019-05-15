/*package Main_Program;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

import Main_Program.HypergraphGUI.DiffCalcProgress;
import javafx.util.converter.BigIntegerStringConverter;

public class example2 {
	
	//new DiffCalcProgress(progressBar).execute();

	static class DiffCalcProgress extends SwingWorker<Void, Integer> {

		JProgressBar pb;
		BigInteger big = (BigInteger)new BigIntegerStringConverter().fromString("7547442");
		BigInteger x = BigInteger.ZERO;
		BigInteger hungred = BigInteger.valueOf(100);

		public DiffCalcProgress(JProgressBar pb) {
			this.pb = pb;
		}

		@Override
		protected void process(List<Integer> chunks) {
			int i = chunks.get(chunks.size() - 1);
			pb.setValue(i);
		}

		@Override
		protected Void doInBackground() throws Exception {// publish(i)
			count = BigInteger.valueOf(0);
			recCount(new ArrayList<Integer>(Ii), new ArrayList<Integer>(), LR);
			BigInteger N = fact(BigInteger.valueOf(LR));
			//N = N;//.multiply(count);// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			textField_4.setText(count.toString());
			return null;
		}

		void recCount(ArrayList<Integer> a, ArrayList<Integer> v, int k) {
			ArrayList<Integer> tempA = new ArrayList<Integer>(a);
			ArrayList<Integer> tempV = new ArrayList<Integer>(v);

			if (k > 0) {
				for (int i = 0; i < I; i++) {
					if (a.get(i) > 0) {
						tempA.set(i, tempA.get(i) - 1);
						tempV.add(i);
						recCount(tempA, tempV, k - 1);
						tempA.clear();
						tempA.addAll(a);
						tempV.clear();
						tempV.addAll(v);
					}
				}
			} else {
				count = count.add(BigInteger.valueOf(1));
				//publish((((BigInteger)new BigIntegerStringConverter().fromString("173881575296000")).divide((BigInteger) new BigIntegerStringConverter().fromString("2738815752960"))).intValue());
				//publish((count.multiply(BigInteger.valueOf(100))
				//		.divide((BigInteger) new BigIntegerStringConverter().fromString("2738815752960"))).intValue());
				x=count.multiply(hungred);
				x=x.divide(big);
				publish(x.intValue());
				return;
			}
			return;
		}
	}

}*/
