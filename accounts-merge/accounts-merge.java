class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> parents = new HashMap<>();
        Map<String, TreeSet<String>> unions = new HashMap<>();
        Map<String, String> owners = new HashMap<>();
        //Initialise parents to itself
        for(List<String> mails: accounts){
            for(int i=1;i<mails.size();i++){
                parents.put(mails.get(i), mails.get(i));
                owners.put(mails.get(i), mails.get(0));
            }
        }
        // Connect all parents to a group using union find
        for(List<String> mails: accounts){
            String parent = find(mails.get(1), parents);
            for(int i=2;i<mails.size();i++){
                parents.put(find(mails.get(i), parents), parent);
            }
        }
        //Assemble and sort
        for(List<String> mails: accounts){
            String parent = find(mails.get(1), parents);
            if(!unions.containsKey(parent))unions.put(parent, new TreeSet<>());
            for(int i=1;i<mails.size();i++){
                unions.get(parent).add(mails.get(i));
            }
        }
        //Assemble for output
        List<List<String>> result = new ArrayList<>();
        for(String key: unions.keySet()){
            List<String> emails = new ArrayList<>(unions.get(key));
            emails.add(0, owners.get(key));
            result.add(emails);
        }
        return result;
    }
    
    public String find(String element, Map<String, String> parents){
        if(parents.get(element)==element)return element;
        else return find(parents.get(element), parents);
    }
}