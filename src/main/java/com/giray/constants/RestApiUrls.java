package com.giray.constants;

public class RestApiUrls {
    private static final String VERSION = "/v1";
    private static final String API = "/api";
    private static final String TEST = "/test";
    private static final String DEV = "/dev";
    private static final String PROD = "/prod";


    private static final String ROOT = DEV + VERSION;
    public static final String CART = ROOT + "/carts";
    public static final String CARTITEM = ROOT + "/cartItems";
    public static final String CUSTOMER = ROOT + "/customers";
    public static final String ORDER = ROOT + "/orders";
    public static final String PRODUCT = ROOT + "/products";



    public static final String CREATE = "/create";
    public static final String UPDATE = "/update";
    public static final String SAVE = "/save";
    public static final String ADD = "/add";
    public static final String GET_ALL = "/get-all";
    public static final String GET_BY_ID = "/get-by-id";
    public static final String DELETE_BY_ID = "/delete-by-id";
    public static final String CREATE_ERROR = "/create-error";
    public static final String REGISTER = ROOT + "/register";


}
