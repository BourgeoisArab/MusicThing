package core;

public class Rhythm {
    // Rhythm's notes ratio based on duration
    public int[] ratio;
    // Note duration 1/4 - crotchet
    public int duration;
    
    // 2 Eighth notes - d = 1/4, r = 1/2, 1/2
    /**
     * 
     * @param r - rhythmic ratios, r sum <= 1. Negative ratios signify rests
     * @param d - rhythm duration relative to that of a semi-breve
     */
    public Rhythm(int [] r,int d)
    {
        ratio = r;
        duration = d;
    }
    
    public static Rhythm[] Split(int step) // Splits d and ratios symmetrically by step(ratio)
    {
         return new Rhythm[]{};
    } 
    public static Rhythm Combine(Rhythm c) // Combined ratios, increased d
    {
        return new Rhythm(new int[1],0);     
    }
    public static Rhythm Merge(Rhythm c) // merged rations, same d
    {
        return new Rhythm(new int[1],0);
    }
    public int[] AbosluteDuration()
    {
        int[] absoluteDuration = new int[ratio.length];
        for(int i = 0;i < ratio.length-1;i++)
            absoluteDuration[i] = ratio[i] * duration;
        return absoluteDuration;
    }
}


