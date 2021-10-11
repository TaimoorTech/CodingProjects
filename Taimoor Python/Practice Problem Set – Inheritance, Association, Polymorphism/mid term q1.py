class Stadium:
    name = "Gaddafi Stadium"

    def __init__(self, pitch="", c=0):
        self.pitch = pitch
        self.capacity = c

    def set_pitch(self, p):
        self.pitch = p

    def get_pitch(self):
        return self.pitch

    def set_capacity(self, c):
        self.capacity = c

    def get_capacity(self):
        return self.capacity


class matches(Stadium):
    count = 0

    def __init__(self, pitch="", c=0, t1="", t2=""):
        matches.count += 1
        self.team1 = t1
        self.team2 = t2
        super().__init__(pitch, c)

    def set_team1(self, t):
        self.team1 = t

    def get_team1(self):
        return self.team1

    def set_team2(self, t):
        self.team2 = t

    def get_team2(self):
        return self.team2


class information(matches):

    def __init__(self, pitch="", c=0, t1="", t2="", score_batfirst=0, score_batsecond=0, win=""):
        self.score_batfirst = score_batfirst
        self.score_batsecond = score_batsecond
        self.win = win
        super().__init__(pitch, c, t1, t2)

    def set_score_batfirst(self, s):
        self.score_batfirst = s

    def get_score_batfirst(self):
        return self.score_batfirst

    def set_score_batsecond(self, s):
        self.score_batsecond = s

    def get_score_batsecond(self):
        return self.score_batsecond

    def set_win(self, w):
        self.win = w

    def get_win(self):
        return self.win


m1 = information("dry", 18000, "pak", "eng", 144, 122, "pak")
m2 = information("hard", 18000, "eng", "sa", 280, 282, "sa")
print(m2.count)