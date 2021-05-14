/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.order.Order;
import java.util.Scanner;

/**
 *
 * @author maiphong.0411
 */

public class Aims {
    public static void main(String[] args) {
        Order myOrder = null;
        int select;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Order Management Application: ");
            System.out.println("--------------------------------");
            System.out.println("1. Create an order");
            System.out.println("2. Add item to the order");
            System.out.println("3. Delete item by id");
            System.out.println("4. Display the items list of order");
            System.out.println("0. Exit");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4");
            select = sc.nextInt();

            switch (select) {
                case 1 -> myOrder = new Order();
                case 2 -> {
                    try {
                        Media media = null;
						try {
							media = getItem();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                        if (media != null)
                            myOrder.addMedia(media);
                        else
                            System.out.println("Invalid!");
                    } catch (NullPointerException e) {
                        System.out.println("Order does not exist");
                    }
                }
                case 3 -> {
                    try {
                        System.out.println("Input ID: ");
                        int ID = sc.nextInt();
                        myOrder.removeMedia(ID);
                    } catch (NullPointerException e) {
                        System.out.println("Order does not exist");
                    }
                }
                case 4 -> {
                    try {
                        myOrder.showOrder();
                    } catch (NullPointerException e) {
                        System.out.println("Order does not exist");
                    }
                }
                default -> {}
            }
            System.out.println("");
        } while(select != 0);
    }
    public static Media getItem() throws Exception {
        int type;
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose type of media: ");
        System.out.println("1. Book");
        System.out.println("2. CompactDisc");
        System.out.println("3. DigitalVideoDisc");
        type = sc.nextInt();
        switch (type) {
            case 1 -> {
                Book book = new Book();
                System.out.println("Book ID: "); try {
					book.setID(sc.nextInt());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} sc.nextLine();
                System.out.println("Book Title: "); try {
					book.setTitle(sc.nextLine());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                System.out.println("Book Category: "); try {
					book.setCategory(sc.nextLine());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                System.out.println("Book Cost: "); try {
					book.setCost(sc.nextFloat());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} sc.nextLine();
                System.out.println("Book Authors: ");
                for (var author : sc.nextLine().split(" ")) {
                    try {
						book.addAuthor(author);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                }
                return book;
            }
            case 2 -> {
                CompactDisc cd = new CompactDisc();
                System.out.println("CD ID: "); try {
					cd.setID(sc.nextInt());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} sc.nextLine();
                System.out.println("CD Title: "); try {
					cd.setTitle(sc.nextLine());
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
                System.out.println("CD Category: "); try {
					cd.setCategory(sc.nextLine());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                System.out.println("CD Cost: "); try {
					cd.setCost(sc.nextFloat());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} sc.nextLine();
                System.out.println("CD Director: "); cd.setDirector(sc.nextLine());
                System.out.println("CD Artist: "); try {
					cd.setArtist(sc.nextLine());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                String select;
                do {
                    System.out.println("Add track? Y/N");
                    select = sc.nextLine();
                    if (select.equals("Y") || select.equals("y")) {
                        Track track = new Track();
                        System.out.println("Track title: "); track.setTitle(sc.nextLine());
                        System.out.println("Track length: "); track.setLength(sc.nextInt()); sc.nextLine();
                        cd.addTrack(track);
                    }
                    else
                        break;
                } while (true);
                
                // Ask for play CD
                System.out.println("Play CD? Y/N");
                select = sc.nextLine();
                if (select.equals("Y") || select.equals("y"))
                    cd.play();

                return cd;
            }
            case 3 -> {
                DigitalVideoDisc dvd = new DigitalVideoDisc();
                System.out.println("DVD ID: "); try {
					dvd.setID(sc.nextInt());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} sc.nextLine();
                System.out.println("DVD Title: "); try {
					dvd.setTitle(sc.nextLine());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                System.out.println("DVD Category: "); try {
					dvd.setCategory(sc.nextLine());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                System.out.println("DVD Cost: "); try {
					dvd.setCost(sc.nextFloat());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} sc.nextLine();
                System.out.println("DVD Director: "); dvd.setDirector(sc.nextLine());
                System.out.println("DVD Length: "); dvd.setLength(sc.nextInt()); sc.nextLine();
                
                // Ask for play DVD
                System.out.println("Play DVD? Y/N");
                String select = sc.nextLine();
                if (select.equals("Y") || select.equals("y"))
                    dvd.play();
                
                return dvd;
            }
            default -> { return null; }
        }
    }
}
