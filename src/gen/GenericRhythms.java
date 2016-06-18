package gen;
import core.Rhythm;

//TODO, come up with a better way to categorize rhythms. Maybe just a list afterall?

public enum GenericRhythms {
    Quarter(new Rhythm(new int[]{1},1/4)),
    TwoEigthsQuarter(new Rhythm(new int[]{1/2,1/2},1/4)),
    DottedEighthNoteSixteenthNote(new Rhythm(new int[]{3/4,1/4},1/4)),
    FunnyOne(new Rhythm(new int[]{1/4,-1/4,1/4,-1/4},1/4));
    
    public final Rhythm value;

    private GenericRhythms(Rhythm value) {
        this.value = value;
    }
}
