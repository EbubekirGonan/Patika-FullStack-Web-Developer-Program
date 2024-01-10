public class Book implements Comparable<Book> {

    private String name;
    private int numOfPages;
    private String authorName;
    private String publishDate;

    public Book(String name, Integer numOfPages, String authorName, String publishDate) {
        this.name = name;
        this.numOfPages = numOfPages;
        this.authorName = authorName;
        this.publishDate = publishDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumOfPages() {
        return numOfPages;
    }

    public void setNumOfPages(Integer numOfPages) {
        this.numOfPages = numOfPages;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }
    @Override
    public int compareTo(Book name) {
        return this.name.compareTo(name.getName());
    }

}
