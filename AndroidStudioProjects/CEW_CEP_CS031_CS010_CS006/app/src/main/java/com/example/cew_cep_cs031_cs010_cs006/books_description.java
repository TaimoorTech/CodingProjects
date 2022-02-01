package com.example.cew_cep_cs031_cs010_cs006;

import java.util.ArrayList;

public class books_description {

    public books_description(){

    }

    public  String[] get_description(){
        String[] des = {"Harry Potter and the Philosopher's Stone is a fantasy novel." +
                "The first novel in the Harry Potter series and Rowling's debut novel," +
                "it follows Harry Potter, a young wizard who discovers his magical heritage " +
                "on his eleventh birthday,when he receives a letter of acceptance to Hogwarts " +
                "School of Witchcraft and Wizardry. and the Journey Begins.\n\n" +
                "The book was first published in the United Kingdom on 26 June 1997 by Bloomsbury." +
                "The novel has sold in excess of 120 million copies, " +
                "making it the third best-selling novel of all time. ",

                "Harry Potter and the Chamber of Secrets is a fantasy novel written by British author " +
                        "J.K. Rowling and the second novel in the Harry Potter series. " +
                        "The plot follows Harry's second year at Hogwarts School of Witchcraft and Wizardry, " +
                        "during which a series of messages on the walls of the school's corridors " +
                        "warn that the \"Chamber of Secrets\" has been opened and that the " +
                        "\"heir of Slytherin\" would kill all pupils w" +
                        "ho do not come from all-magical families.\n\nThe book was published in the " +
                        "United Kingdom on 2 July 1998 by Bloomsbury and later in the United States " +
                        "on 2 June 1999 by Scholastic Inc.",

                "Harry Potter and the Prisoner of Azkaban is a fantasy novel written by British "+
                        "author J.K. Rowling and is the third in the Harry Potter series. " +
                        "The book follows Harry Potter, a young wizard, in his third year " +
                        "at Hogwarts School of Witchcraft and Wizardry. Along with friends " +
                        "Ronald Weasley and Hermione Granger, Harry investigates Sirius Black, " +
                        "an escaped prisoner from Azkaban, the wizard prison, believed to be " +
                        "one of Lord Voldemort's old allies.\n\nThe film adaptation of the novel was " +
                        "released in 2004, grossing more than $796 million and earning critical " +
                        "acclaim.",

                "Amara the Brave is a novel written by Matt Zhang.Amara, a jobless youngster who " +
                        "comes to Madurai to help his aunt, a vegetable vendor, with her business " +
                        "ends up incurring the wrath of an Assistant Commissioner of Police. He is " +
                        "forced to flee for his life. While on the run, he ends up meeting a " +
                        "politician’s daughter, Thenmozhi, who, after losing her first love to her " +
                        "dad’s wrath, eventually falls for him.",

                "The Book of Warlock a novel written by J.D. Oliva.he US Military has finally developed " +
                        "the perfect weapon and it’s gone missing.\n\n" +
                        "Desperate, they have reached out assassin Ethan Jericho to take out the man" +
                        " responsible: Crawford Lockhart.\n\n" +
                        "Fifteen years ago, Jericho knew Lockhart by another name—Warlock. " +
                        "Now, Jericho faces a heart-wrenching offer: kill Warlock, " +
                        "and the government will clear his record.\n\n" +
                        "But when Jericho confronts his old friend, " +
                        "he discovers Warlock’s weapon is a five-year-old girl" +
                        "blessed with an unholy ability. And worse, Jericho isn’t the only " +
                        "one tracking them down.",


                "Catching Fire is a 2009 science fiction young adult novel by the American novelist " +
                        "Suzanne Collins, the second book in The Hunger Games series. As the sequel " +
                        "to the 2008 bestseller The Hunger Games, it continues the story of Katniss " +
                        "Everdeen and the post-apocalyptic nation of Panem. Following the events of " +
                        "the previous novel, a rebellion against the oppressive Capitol has begun, " +
                        "and Katniss and fellow tribute Peeta Mellark are forced to return to the " +
                        "arena in a special edition of the Hunger Games.\n\nThe book was first " +
                        "published on September 1, 2009, by Scholastic, in hardcover, and was later " +
                        "released in ebook and audiobook format. Catching Fire received mostly " +
                        "positive reviews. The book has sold more than 19 million copies in the U.S." +
                        " alone.",

                "The Dreaming Arts a book written by Tom Maloney.The Dreaming Arts is a book" +
                        " about sleep and dreams and how to use them as a vehicle for personal " +
                        "evolution.\n\nAll ages except children, men and women. People that are into" +
                        " health, wellness, non-mainstream, alternative, independent thinkers, " +
                        "open minded, and intelligent.",

                "Robin MacArthur’s newest book is a meditation on the connections between adulthood " +
                        "and the land of ancestors. “Heart Spring Mountain” explores the buried " +
                        "emotions that surface when a woman, Vale, returns to her hometown after her" +
                        " drug-addicted mother, Bonnie, disappears in a hurricane. The story slowly " +
                        "weaves through several generations of the same family, exposing how the past" +
                        " influences the present. Although MacArthur has written a narrative filled " +
                        "with compelling reflections on the past’s impact and global warming’s " +
                        "repercussions, the present plot offers very little action. This is a novel " +
                        "more focused on thought than experience.",


                "The Author of the Book is JK Rowling. It was released in 2018.",


                "A fantastic novel by Robert A. Heinlein. Jim Marlow and his strange-looking" +
                                " Martian friend Willis were allowed to travel only so far. " +
                                "But one day Willis unwittingly tuned into a treacherous plot that " +
                                "threatened all the colonists on Mars, and it set Jim off on a " +
                                "terrfying adventure that could save--or destroy--them all!\n",

                "A novel by Christian Nadeau.s a former assassin, a man on the run for years, " +
                        "Marac survived taking on odd jobs, living on society’s fringe, never " +
                        "putting down roots for fear of having to run again. Until he’s hired to " +
                        "steal a trinket from the Brotherhood.\n" +
                        "\n" +
                        "Newly graduated, Soren is ready to shoulder the responsibilities that come " +
                        "with an officer’s commission. Serving in the Brotherhood of Khan is a " +
                        "privilege, one he abandoned everything for. \n" +
                        "\n" +
                        "As a Lightbearer, gifted with the power to shape light to her will, " +
                        "Alex lived a sheltered life in Tyranor’s monastery. Should the Brotherhood " +
                        "find out what she was, they’d kill her, but the monastery is underground, " +
                        "safely hidden from their prying eyes.",

                "The Author of the Book is JK Rowling. It was released in 2021.",

                "he Girl on the Train is a 2015 psychological thriller novel by British author " +
                        "Paula Hawkins that gives narratives from three different women about " +
                        "relationship troubles (caused by three coercive/controlling men) and, " +
                        "for the main protagonist, alcoholism. The novel debuted in the number one " +
                        "spot on The New York Times Fiction Best Sellers of 2015 list " +
                        "(print and e-book) dated 1 February 2015\n\nBy early August, the book had " +
                        "sold more than three million copies in the U.S. alone, and, by October " +
                        "2016, an estimated 20 million copies worldwide."};
        return des;
    }
}
