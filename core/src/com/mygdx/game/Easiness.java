package com.mygdx.game;
import Java.util.ArrayList;

import java.util.ArrayList;

public class Easiness {

    public static void main(String[] args){
        ArrayList<Executable>  easinessEvents = new ArrayList<Executable>();
        easinessEvents.add(new Event("Your whole class fails a midterm.",
                new Option( "You decide to curve the midterm", "The students are grateful and all pass the class",
                    new StatChange(Professor.Stat.EASINESS,  15), new StatChange(Professor.Stat.ACCESSIBILITY, 5)),
                new Option("You ignore their emails and let your TA handle grades", new ResourceChange(Professor.Resource.TA, -1)
                , "Your TA quits out of frustration and you joke about it in class", new StatChange(Professor.Stat.HUMOR, 5), new StatChange(Professor.Stat.ACCESSIBILITY(), -10), new StatChange(Professor.Stat.EASINESS, -15)),
                new Option("You tell them how disappointed you are", "You upset them and many of them drop",
                        new StatChange(Professor.Stat.ACCESSIBILITY, -10), new StatChange(Professor.Stat.HEALTH, 5),
                        new StatChange(Professor.Stat.EASINESS, -10))
        ));

        easinessEvents.add(new Event("You catch a student cheating on their labs",
                new Option( "You immediately drop them from the class", "They are upset, but the rest of the students are grateful",
                        new StatChange(Professor.Stat.EASINESS,  -5), new StatChange(Professor.Stat.ACCESSIBILITY, 5), new StatChange(Professor.Stat.ENGAGEMENT, 10)),
                new Option("You take a bribe to overlook their offense", "Students complain to the department head about the injustice",
                        new StatChange(Professor.Stat.ACCESSIBILITY(), -10), new StatChange(Professor.Stat.EASINESS, 10), new StatChange(Professor.Stat.HEALTH, -10)),
                new Option("You make an announcement in class hoping to draw out other cheaters", new ResourceChange(Professor.Resource.CHALK, -1),
                        new StatChange(Professor.Stat.ACCESSIBILITY, -5),
                        new Event("Several other students come forward as cheaters",
                                new Option("Punish all of the cheaters", "The cheaters all riot and give you a bad rating on RateMyProfessor",
                                        new StatChange(Professor.Stat.EASINESS, -5), new StatChange(Professor.Stat.ACCESSIBILITY,-5), new StatChange(Professor.Stat.ENGAGEMENT,15)),
                                new Option("Forgive all of the cheaters", "Other students are upset, but the cheaters are thankful",
                                        new StatChange(Professor.Stat.ENGAGEMENT,-10), new StatChange(Professor.Stat.HEALTH,-5)))
                        )
        ));

        easinessEvents.add(new Event("Everyone gets an A in your class",
                new Option("You curve the class down to a B- average", "Students are unhappy with their new grades",
                        new StatChange(Professor.Stat.EASINESS, -15), new StatChange(Professor.Stat.ACCESSIBILITY, -5), new StatChange(Professor.Stat.HEALTH, 5)),
                new Option("You pretend to change their grades, but leave everyone's grades as they are", "The students are relieved",
                        new StatChange(Professor.Stat.EASINESS, 15), new StatChange(Professor.Stat.HUMOR, 10))
                new Option("You give everyone an A+", new ResourceChange(Professor.Resource.YERBA, 1), "They throw a party in your honor",
                        new StatChange(Professor.Stat.ENGAGEMENT, 10), new StatChange(Professor.Stat.EASINESS, 15), new StatChange(Professor.Stat.HEALTH, -10))
        ));
    }
}
