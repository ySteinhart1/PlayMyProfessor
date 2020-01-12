package com.mygdx.game;
import com.mygdx.game.Event;


import java.util.ArrayList;

public class OtherEvents {

    public static void main(String[] args) {
        ArrayList<Executable> humorEvents = new ArrayList<Executable>();
        humorEvents.add(new Event("You make a joke, but you are met with a deafening silence by your class.",
                new Option("Get angry at the class for not appreciating your godly humor", "The class is uncomfortable and does not know how to react.",
                        new StatChange(Professor.Stat.HEALTH, -5), new StatChange(Professor.Stat.HUMOR, -15)),
                new Option("Tease a student to lower the tension", "The student becomes upset, but the class is in a better mood",
                        new StatChange(Professor.Stat.HUMOR, 10), new StatChange(Professor.Stat.ACCESSIBILITY, -15), new StatChange(Professor.Stat.ENGAGEMENT, 5)),
                new Option("Push through to try to move on", "The class moves on with some students no longer paying attention",
                        new StatChange(Professor.Stat.HUMOR, -5), new StatChange(Professor.Stat.ENGAGEMENT, -10))));

        humorEvents.add(new Event("A student comes to you during office hours to tell you that he was offended about a joke you made in class",
                new Option("Ignore the student's issue", "The student complains to the class, but your reputation remains relatively unchanged",
                        new StatChange(Professor.Stat.ACCESSIBILITY, -10)),
                new Option("Stay up all night composing a well-thought-out message apologizing to the class", new ResourceCost(Professor.Resource.YERBA,2),
                        "The class is happy to see that you care about their concerns",
                        new StatChange(Professor.Stat.ACCESSIBILITY, 15), new StatChange(Professor.Stat.HEALTH,-5)),
                new Option("Tell the student you will make an announcement, but don't do it and hope they forget.",
                        "The student is happy for a minute, but you become known as a liar and students pay less attention to you",
                        new StatChange(Professor.Stat.ENGAGEMENT,-10))));

        humorEvents.add(new Event("You make an amazing joke and the whole class laughs. What do you do now?",
                new Option("Quit while you're ahead and call it a day", "The class is happy and so are you.",
                        new StatChange(Professor.Stat.HUMOR, 10)),
                new Option("Try to make a knock-knock joke to be even funnier", "The class chuckles nervously. Apparently, knock-knock jokes are no longer \"in\"",
                        new StatChange(Professor.Stat.HUMOR, -5)),
                new Option("Make a \'yo mama\' joke", "That was pretty funny!",
                        new StatChange(Professor.Stat.HUMOR, 15), humorEvents.get(1))));



        ArrayList<Executable> randomStatChanges = new ArrayList<Executable>();
        randomStatChanges.add(new StatChange(Professor.Stat.ACCESSIBILITY, 10, "Your candy stockpile in your office gets refilled, so more students come"));
        randomStatChanges.add(new StatChange(Professor.Stat.ACCESSIBILITY, -10, "Your department forces you to close some of your office hours."));

        randomStatChanges.add(new StatChange(Professor.Stat.ENGAGEMENT, -10, "You have to attend a colloquim and have to cancel for a week."));
        randomStatChanges.add(new StatChange(Professor.Stat.ENGAGEMENT, 10, "You buy a new book that gives you insights into teaching successfully"));

        randomStatChanges.add(new StatChange(Professor.Stat.EASINESS, 15, "Your department allows you to have a more generous curve for the class"));
        randomStatChanges.add(new StatChange(Professor.Stat.EASINESS, -10, "Your TA gets annoyed at some loud students in class and convinces you to write harder tests"));

        randomStatChanges.add(new StatChange(Professor.Stat.HEALTH, 10, "Your university offers free yoga nights that you attend religiously"));
        randomStatChanges.add(new StatChange(Professor.Stat.HEALTH, -15, "You have a child, causing you to spend many sleepless nights taking care of him"));

        randomStatChanges.add(new StatChange(Professor.Stat.HUMOR, 15, "You devote your evenings to attending a comedy club and pick up some of the funniest jokes");
        randomStatChanges.add(new StatChange(Professor.Stat.HUMOR, -10, "You find a new joke online, but it totally flops."));

    }
}
