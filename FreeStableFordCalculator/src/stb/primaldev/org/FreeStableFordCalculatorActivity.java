package stb.primaldev.org;


import golf.primaldev.org.StableFord;
import stableford.primaldev.org.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class FreeStableFordCalculatorActivity extends Activity {
	private TextView holeScore;
	private TextView plHandicap;
	private TextView strokeIndex;
	private TextView holePar;
	private TextView stableFordScore;
	private StableFord stableFordcalc;
	private RadioButton nineHoles;
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        holeScore = (TextView) findViewById(R.id.holeScore);
        plHandicap = (TextView) findViewById(R.id.plHandicap);
        strokeIndex = (TextView) findViewById(R.id.strokeIndex);
        holePar = (TextView) findViewById(R.id.holePar);
        stableFordScore = (TextView) findViewById(R.id.stableFordScore);
        nineHoles = (RadioButton) findViewById(R.id.nineHoles);
        stableFordcalc = new StableFord(Integer.parseInt((String) plHandicap.getText()),Integer.parseInt((String) strokeIndex.getText()),Integer.parseInt((String) holePar.getText()),Integer.parseInt((String) holeScore.getText()),nineHoles.isChecked());
        stableFordScore.setText(String.valueOf(stableFordcalc.getStableFord()));
        
    }
    
    public void nineEighteenSelected(View v){
    	
    	stableFordcalc.setNineHoles(nineHoles.isChecked());
    	stableFordScore.setText(String.valueOf(stableFordcalc.getStableFord()));
    }
    
	public void holeScoreUpClicked(View v) {		
		checkScore(1);		
	}
	
	public void holeScoreDownClicked(View v) {
		checkScore(-1);		
	}
	
	private void checkScore(int incValue){
		stableFordcalc.setScore(stableFordcalc.getScore() + incValue);
		if (stableFordcalc.getScore() < 1) {
			stableFordcalc.setScore(1);
		}
		holeScore.setText(String.valueOf(stableFordcalc.getScore()));
		stableFordScore.setText(String.valueOf(stableFordcalc.getStableFord()));
	}
	
	
	public void plHandicapUpClicked(View v){
		checkPlHandicap(1);
	}
	
	public void plHandicapDownClicked(View v) {
		checkPlHandicap(-1);
	}
	
	private void checkPlHandicap(int incValue) {
		stableFordcalc.setPlayingHandicap(stableFordcalc.getPlayingHandicap() + incValue);
		
		if (stableFordcalc.getPlayingHandicap() < 0){
			stableFordcalc.setPlayingHandicap(67);
		}
		if (stableFordcalc.getPlayingHandicap() > 67){
			stableFordcalc.setPlayingHandicap(0);
		}
		plHandicap.setText(String.valueOf(stableFordcalc.getPlayingHandicap()));
		stableFordScore.setText(String.valueOf(stableFordcalc.getStableFord()));
		
	}
	
	public void strokeIndexUpClicked(View v) {
		checkStrokeIndex(1);
	}

	
	public void strokeIndexDownClicked(View v) {
		checkStrokeIndex(-1);
	}
	
	private void checkStrokeIndex(int incValue){
		stableFordcalc.setStrokeIndex(stableFordcalc.getStrokeIndex() + incValue);
		
		if (stableFordcalc.getStrokeIndex()< 1) {
			stableFordcalc.setStrokeIndex(18);
		}
		
		if (stableFordcalc.getStrokeIndex()> 18) {
			stableFordcalc.setStrokeIndex(1);
		}
		
		strokeIndex.setText(String.valueOf(stableFordcalc.getStrokeIndex()));
		stableFordScore.setText(String.valueOf(stableFordcalc.getStableFord()));
	}
	
	
	public void holeParUpClicked(View v) {
		checkPar(1);
		
	}
	
	public void holeParDownClicked(View v) {
		checkPar(-1);
		
	}
	
	private void checkPar(int incValue){
		stableFordcalc.setHolePar(stableFordcalc.getHolePar() + incValue);
		
		if (stableFordcalc.getHolePar()< 3) {
			stableFordcalc.setHolePar(6);
		}
		if (stableFordcalc.getHolePar()> 6) {
			stableFordcalc.setHolePar(3);
		}	
		
		holePar.setText(String.valueOf(stableFordcalc.getHolePar()));
		stableFordScore.setText(String.valueOf(stableFordcalc.getStableFord()));
	}
	

}