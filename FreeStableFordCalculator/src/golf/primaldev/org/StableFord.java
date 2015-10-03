package golf.primaldev.org;




public class StableFord {
	public int playingHandicap;
	public int strokeIndex;
	public int holePar;
	public int score;
	public boolean nineHoles;
	
	
	
	public StableFord() {
		super();
	}



	public StableFord(int playingHandicap, int strokeIndex, int holePar,
			int score, boolean nineHoles) {
		super();
		this.playingHandicap = playingHandicap;
		this.strokeIndex = strokeIndex;
		this.holePar = holePar;
		this.score = score;
		this.nineHoles = nineHoles;
	}



	public int getPlayingHandicap() {
		return playingHandicap;
	}



	public void setPlayingHandicap(int playingHandicap) {
		this.playingHandicap = playingHandicap;
	}



	public int getStrokeIndex() {
		return strokeIndex;
	}



	public void setStrokeIndex(int strokeIndex) {
		this.strokeIndex = strokeIndex;
	}



	public int getHolePar() {
		return holePar;
	}



	public void setHolePar(int holePar) {
		this.holePar = holePar;
	}



	public int getScore() {
		return score;
	}



	public void setScore(int score) {
		this.score = score;
	}



	public boolean isNineHoles() {
		return nineHoles;
	}



	public void setNineHoles(boolean nineHoles) {
		this.nineHoles = nineHoles;
	}
	
	
	public int getStableFord(){
		int adjStbfPar = getHolePlayingPar() + 2;
		
		if (adjStbfPar <= score) {
			return 0;
		}else{
			return adjStbfPar - score;
		}
		
		
	}
	
	public int getHolePlayingPar(){
		int extra=0;
		int adjSI;
		
		if (nineHoles) {
			if (strokeIndex % 2 ==0) {
				adjSI = strokeIndex / 2;
			} else {
				adjSI = (strokeIndex + 1) /2;
				
			}
			
			if (adjSI + 9 <= playingHandicap) {				
				extra =playingHandicap / 9 ;
				
				if (playingHandicap > (extra * 9)) {
					if((playingHandicap - (extra * 9)) >= adjSI ) {
						extra++;
					}
				}
				
			} else {
				if (adjSI <= playingHandicap) {
					extra=1;
				}else{
					extra=0;
				}
			} 
			
		}else{
			
			if (strokeIndex <= playingHandicap) {
				extra = (int) (playingHandicap / 18);
				int res = playingHandicap - extra * 18;
				if (strokeIndex <= res) {
					extra++;
				}
				
			} else {
				extra = 0;
			}
		}
		
		return extra + holePar;
	}

}
