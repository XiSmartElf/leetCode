package leetCode.Backtracking;
//I used A* but I cannot believe I got TLE

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class _126_Word_Ladder_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Set<String> dict = new HashSet<String>(Arrays.asList("kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab","ago","ina","big","ilk","gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han","met","hut","she","sac","fed","goo","tee","ell","not","act","gil","rut","ala","ape","rig","cid","god","duo","lin","aid","gel","awl","lag","elf","liz","ref","aha","fib","oho","tho","her","nor","ace","adz","fun","ned","coo","win","tao","coy","van","man","pit","guy","foe","hid","mai","sup","jay","hob","mow","jot","are","pol","arc","lax","aft","alb","len","air","pug","pox","vow","got","meg","zoe","amp","ale","bud","gee","pin","dun","pat","ten","mob"
));
		String start ="cet";
		String end = "ism";
		final long startTime = System.currentTimeMillis();

		System.out.println(findLadders(start, end, dict));
		final long endTime = System.currentTimeMillis();

		System.out.println("Total execution time: " + (endTime - startTime) );
		
	}

    public static List<List<String>> findLadders(String start, String end, Set<String> dict) {
    	PriorityQueue<node> queue = new PriorityQueue<node>(dict.size()* start.length(), new Comparator<node>(){
            @Override
            public int compare(node o1,node o2){
                if (o1.cost<o2.cost)
                    return -1;
                else if (o1.cost==o2.cost)
                    return 0;
                else 
                    return 1;
            }
        });
        node startNode = new node(0, new HashSet<String>(), start);
        queue.add(startNode);
        dict.add(end);
        List<List<String>> res = new ArrayList<List<String>>();
        int bestCost = 0;
        boolean firstTime =true;
        outloop:
        while(!queue.isEmpty())
        {
            node cur_node = queue.poll();
            ArrayList<String> childs = findChild(cur_node, dict);
            for(String child: childs)
            {
                node childNode = new node(cur_node.cost+1, cur_node.path, child);
                if(child.equals(end))
                {
                	if(firstTime == true)
                	{
                		bestCost = childNode.cost; firstTime = false;
                	}
                	else
                	{
                		if(childNode.cost>bestCost)
                			break outloop;
                	}
                    res.add(new ArrayList<String>(childNode.path));
                    continue;
                }
                else
                {
                    queue.add(childNode);
                }
            }
        }
        
        return res;
    }
    
    public static class node{
        int cost;
        String value;
        HashSet<String> path = new HashSet<String>();
        public node(int cost, HashSet<String> prePath, String value)
        {
            this.value = value;
            this.cost = cost;
            this.path.addAll(prePath);
            this.path.add(value);
        }
    }
    
    public static ArrayList<String> findChild(node parent, Set<String> dict)
    {
        String parentVal = parent.value;
        ArrayList<String> childs = new ArrayList<String>();
        for(String word: dict)
        {
            if(parent.path.contains(word))
                continue;
            else
            {
                int count = 0;
                for(int i=0; i<word.length(); i++)
                {
                    if(word.charAt(i)!=parentVal.charAt(i))
                        count++;
                    if(count>1)
                        break;
                    if(i==word.length()-1)
                        childs.add(word);
                }
            }
        }
        return childs;
    }
}
