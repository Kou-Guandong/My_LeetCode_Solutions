import os
import json
from datetime import date


def read_json_and_write(f_read, f_out):
    with open(f_read) as f1:
        data = json.loads(f1.readlines()[0])

    questions = data['stat_status_pairs']
    questions.sort(key=lambda x: int(x['stat']['frontend_question_id']))

    with open(f_out, 'w+') as f:
        f.writelines(
            'question_id,title,difficulty,total_submitted,total_accepted,ac_rate,frequency\n')
        for q in questions:
            s = q['stat']
            question_id = s['frontend_question_id']
            title = s['question__title']
            difficulty = ['easy', 'medium', 'hard'][q['difficulty']['level'] - 1]
            total_submitted = s['total_submitted']
            total_accepted = s['total_acs']
            ac_rate = format(total_accepted / total_submitted, '.3f')
            frequency = q['frequency']
            if frequency > 0:
                frequency = format(frequency, '.3f')
            f.writelines(','.join(map(
                lambda x: '"' + str(x) + '"', [question_id, title, difficulty, total_submitted, total_accepted, ac_rate, frequency])) + '\n')


read_json_and_write('authenticated-questions.json', 'authenticated-parsed.csv')
