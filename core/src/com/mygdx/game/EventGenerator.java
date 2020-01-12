package com.mygdx.game;
import java.util.ArrayList;
import java.util.Random;

import com.mygdx.game.Event;
import com.mygdx.game.Professor.Stat;
import com.mygdx.game.Professor.Resource;

public class EventGenerator {
    private static ArrayList<Executable> randomStatChanges;
    private static ArrayList<Executable> randomResourceChanges;
    private static ArrayList<Executable> humorEvents;
    private static ArrayList<Executable> engagementEvents;
    private static ArrayList<Executable> easinessEvents;
    private static ArrayList<Executable> accessibilityEvents;
    private static ArrayList<Executable> healthEvents;

    static Random generator = new Random();

    static {
        accessibilityEvents = new ArrayList<Executable>();
        accessibilityEvents.add(new Event("You realize you have a free afternoon.",
                new Option("Hold extra office hours", "No one shows up.", new StatChange(Stat.ACCESSIBILITY, -10), new StatChange(Stat.ENGAGEMENT, -10)),
                new Option("Finish grading a quiz from weeks ago.", new ResourceCost(Resource.TA, 1), "You finish and upload the grades to Gauchospace.", new StatChange(Stat.ACCESSIBILITY, 10)),
                new Option("Go to the gym", new Event("How do you want to exercise?",
                        new Option("Biceps only.", "You wake up very sore the next day.", new StatChange(Stat.HEALTH, 10)),
                        new Option("Treadmill.", "You are physically unable to walk to your car.", new StatChange(Stat.HEALTH, -10), new StatChange(Stat.HUMOR, 5))))));
        accessibilityEvents.add(new Event("It is 2:00 am and you still need to write the exam for tomorrow.",
                new Option("Pull an all-nighter", new ResourceCost(Resource.YERBA, 2), "You somehow finish and make it to class the next day.", new StatChange(Stat.HEALTH, -10), new StatChange(Stat.EASINESS, 5)),
                new Option("Make the TAs do it.", new ResourceCost(Resource.TA, 1), "Your TAs hate you now, but the exam is finished.", new StatChange(Stat.EASINESS, -5), new StatChange(Stat.ACCESSIBILITY, 5))));
        accessibilityEvents.add(new Event("You realize there are 30 students trying to crash your class.",
                new Option("Let them all in.", new ResourceCost(Resource.CHALK, 1), "Your students are pleased but the department is not.", new StatChange(Stat.EASINESS, 5), new ResourceChange(Resource.TA, -1)),
                new Option("Teach another lecture for no additional pay.", "You're now teaching more classes because you care about the students somewhat.", new StatChange(Stat.ENGAGEMENT, 15), new StatChange(Stat.HEALTH, -10)),
                new Option("Yell at them to get out.", "You intimidate your students but keep your sanity.", new StatChange(Stat.ENGAGEMENT, -15), new StatChange(Stat.HEALTH, 5))));

        randomResourceChanges = new ArrayList<Executable>();
        randomResourceChanges.add(new ResourceChange(Resource.TA, -1, "You decide to open another lab time for your class."));
        randomResourceChanges.add(new ResourceChange(Resource.TA, 2, "PStat 120A was cancelled, so some of the extra TAs were given to you."));
        randomResourceChanges.add(new ResourceChange(Resource.YERBA, 3, "During a protest in front of the arbor, your manage to steal a few yerbs in the midst of the chaos."));
        randomResourceChanges.add(new ResourceChange(Resource.YERBA, -1, "You have an existential crisis all night and come to class late."));
        randomResourceChanges.add(new ResourceChange(Resource.CHALK, 3, "You decide to buy some special Japenese chalk."));
        randomResourceChanges.add(new ResourceChange(Resource.CHALK, -1, "You wrote too hard on the chalkboard and broke your favorite chalk."));
        randomResourceChanges.add(new ResourceChange(Resource.LAPTOP, 2, "A few students leave their laptops in class, so you seize the opportunity."));
        randomResourceChanges.add(new ResourceChange(Resource.LAPTOP, -1, "A bicyclist hits you, causing you to drop your laptop bag."));


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


    public static Executable generateEvent(Professor prof) {
        int listToChoose = generator.nextInt(5);

        switch(listToChoose) {
            case 0:
                return generateEventHelper(humorEvents, Stat.HUMOR, prof);
            case 1:
                return generateEventHelper(engagementEvents, Stat.ENGAGEMENT, prof);
            case 2:
                return generateEventHelper(easinessEvents, Stat.EASINESS, prof);
            case 3:
                return generateEventHelper(accessibilityEvents, Stat.ACCESSIBILITY, prof);
            default:
                return generateEventHelper(healthEvents, Stat.HEALTH, prof);
        }
    }

    private static Executable generateEventHelper(ArrayList<Executable> currentEventList, Stat currentStat, Professor prof) {
        int statAmount = prof.getStat(currentStat);
        double normalRange = 100.0/currentEventList.size(); //if it was same chance per event

        int eventToChoose = 0;
        for(; eventToChoose < currentEventList.size()-1; eventToChoose++) {
            int currentRange = (int) Math.floor(normalRange*eventToChoose + (generator.nextGaussian()*10+normalRange));
            if(statAmount < currentRange)
                break;
        }

        return currentEventList.get(eventToChoose);


    }

    public static Executable generateRandomStatsChange(Professor prof) {
        return randomStatChanges.get(generator.nextInt(randomStatChanges.size()));
    }

    public static Executable generateRandomResourceChange(Professor prof) {
        return randomResourceChanges.get(generator.nextInt(randomResourceChanges.size()));
    }
}
