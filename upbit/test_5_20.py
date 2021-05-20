import time
import pyupbit
import datetime
import pandas as pd
import requests
access = ""
secret = ""


def get_balance(ticker):
    balances = upbit.get_balances()
    for b in balances:
        if b['currency'] == ticker:
            if b['balance'] is not None:
                return float(b['balance'])
            else:
                return 0

def get_20(ticker):
    df = pyupbit.get_ohlcv(ticker,interval="minute1",count=21)
    return df

def get_current_price(ticker):
    return pyupbit.get_orderbook(tickers=ticker)[0]["orderbook_units"][0]["ask_price"]

def rsi(ohlc: pd.DataFrame,period: int = 14):
    ohlc["trade_price"] = ohlc["trade_price"]
    delta =ohlc["trade_price"].diff()
    gains, declines = delta.copy(),delta.copy()
    gains[gains<0]=0
    declines[declines>0]=0
    _gain = gains.ewm(com=(period-1),min_periods=period).mean()
    _loss = declines.abs().ewm(com=(period-1),min_periods=period).mean()

    RS = _gain/_loss
    return pd.Series(100-(100/(1+RS)),name="RSI")

upbit = pyupbit.Upbit(access, secret)

while True:
    try:
            print(datetime.datetime.now().strftime('%Y-%m-%d %H:%M:%S'))
            print("KRW : \t\t"+(str)(get_balance("KRW")))
            #ma10 = get_ma10("KRW-ETH")
            get20 = get_20("KRW-ETH")
            state20 = 1 if get20['open'][0] - get20['close'][0] > 0 else [-1 if get20['open'][0] - get20['close'][0] == 0 else 0]
            state19 = 1 if get20['open'][1] - get20['close'][1] > 0 else [-1 if get20['open'][1] - get20['close'][1] == 0 else 0]
            state18 = 1 if get20['open'][2] - get20['close'][2] > 0 else [-1 if get20['open'][2] - get20['close'][2] == 0 else 0]
            state17 = 1 if get20['open'][3] - get20['close'][3] > 0 else [-1 if get20['open'][3] - get20['close'][3] == 0 else 0]
            state16 = 1 if get20['open'][4] - get20['close'][4] > 0 else [-1 if get20['open'][4] - get20['close'][4] == 0 else 0]
            state15 = 1 if get20['open'][5] - get20['close'][5] > 0 else [-1 if get20['open'][5] - get20['close'][5] == 0 else 0]
            state14 = 1 if get20['open'][6] - get20['close'][6] > 0 else [-1 if get20['open'][6] - get20['close'][6] == 0 else 0]
            state13 = 1 if get20['open'][7] - get20['close'][7] > 0 else [-1 if get20['open'][7] - get20['close'][7] == 0 else 0]
            state12 = 1 if get20['open'][8] - get20['close'][8] > 0 else [-1 if get20['open'][8] - get20['close'][8] == 0 else 0]
            state11 = 1 if get20['open'][9] - get20['close'][9] > 0 else [-1 if get20['open'][9] - get20['close'][9] == 0 else 0]
            state10 = 1 if get20['open'][10] - get20['close'][10] > 0 else [-1 if get20['open'][10] - get20['close'][10] == 0 else 0]
            state9 = 1 if get20['open'][11] - get20['close'][11] > 0 else [-1 if get20['open'][11] - get20['close'][11] == 0 else 0]
            state8 = 1 if get20['open'][12] - get20['close'][12] > 0 else [-1 if get20['open'][12] - get20['close'][12] == 0 else 0]
            state7 = 1 if get20['open'][13] - get20['close'][13] > 0 else [-1 if get20['open'][13] - get20['close'][13] == 0 else 0]
            state6 = 1 if get20['open'][14] - get20['close'][14] > 0 else [-1 if get20['open'][14] - get20['close'][14] == 0 else 0]
            state5 = 1 if get20['open'][15] - get20['close'][15] > 0 else [-1 if get20['open'][15] - get20['close'][15] == 0 else 0]
            state4 = 1 if get20['open'][16] - get20['close'][16] > 0 else [-1 if get20['open'][16] - get20['close'][16] == 0 else 0]
            state3 = 1 if get20['open'][17] - get20['close'][17] > 0 else [-1 if get20['open'][17] - get20['close'][17] == 0 else 0]
            state2 = 1 if get20['open'][18] - get20['close'][18] > 0 else [-1 if get20['open'][18] - get20['close'][18] == 0 else 0]
            state1 = 1 if get20['open'][19] - get20['close'][19] > 0 else [-1 if get20['open'][19] - get20['close'][19] == 0 else 0]
            state0 = 1 if get20['open'][20] - get20['close'][20] > 0 else [-1 if get20['open'][20] - get20['close'][20] == 0 else 0]
            print((str)(get20))

            now14 = state1+state2+state3+state4+state5+state6+state7+state8+state9+state10+state11+state12+state13+state14


            url = "https://api.upbit.com/v1/candles/minutes/1"
            querystring ={"market":"KRW-ETH","count":"200"}
            response = requests.request("GET",url,params=querystring)
            data = response.json()
            df = pd.DataFrame(data)
            df=df.reindex(index=df.index[::-1]).reset_index()
            nrsi = rsi(df,14).iloc[-1]
            print("rsi : "+str(nrsi))
            print("-----------------")
            time.sleep(1)

    except Exception as e:
        print(e)
        time.sleep(1)
